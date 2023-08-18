package br.com.fiap.creditcardpayment.service;

import br.com.fiap.creditcardpayment.entity.SaleRequest;
import br.com.fiap.creditcardpayment.entity.SaleResponse;
import br.com.fiap.creditcardpayment.integration.CieloSaleIntegrationWithFeign;
import br.com.fiap.creditcardpayment.integration.dto.*;
import br.com.fiap.creditcardpayment.repository.SaveRepositoryWithDynamodb;
import br.com.fiap.creditcardpayment.repository.orm.SaleOrm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SaleService {
    private final String merchantId;
    private final String merchantKey;
    private final SaveRepositoryWithDynamodb repository;
    private final CieloSaleIntegrationWithFeign cieloSaleIntegration;

    public SaleService(
            SaveRepositoryWithDynamodb repository,
            CieloSaleIntegrationWithFeign cieloSaleIntegration,
            @Value("${cielo.merchant-id}") String merchantId,
            @Value("${cielo.merchant-key}") String merchantKey) {
        this.merchantId = merchantId;
        this.repository = repository;
        this.merchantKey = merchantKey;
        this.cieloSaleIntegration = cieloSaleIntegration;
    }

    public SaleResponse sale(final SaleRequest request) {
        CieloSaleResponse response = cieloIntegration(request);
        return saveSale(response);
    }

    private CieloSaleResponse cieloIntegration(final SaleRequest request) {
        final CieloSaleRequest creditCard = new CieloSaleRequest(
                UUID.randomUUID().toString(),
                new CieloCustomer(request.customerName()),
                new CieloPaymentRequest(
                        "CreditCard",
                        request.amount(),
                        1,
                        "",
                        new CieloCreditCard(request.cardToken())
                )
        );
        return cieloSaleIntegration.sale(merchantId, merchantKey, creditCard);
    }

    private SaleResponse saveSale(final CieloSaleResponse cieloSaleResponse) {
        SaleOrm saleOrm = new SaleOrm();
        saleOrm.setId(UUID.randomUUID().toString());
        saleOrm.setAmount(cieloSaleResponse.payment().amount());
        saleOrm.setMerchantOrderId(cieloSaleResponse.merchantOrderId());
        saleOrm.setPaymentId(cieloSaleResponse.payment().paymentId());
        saleOrm.setStatus(cieloSaleResponse.payment().status());
        SaleOrm save = repository.save(saleOrm);
        return new SaleResponse(
                save.getMerchantOrderId(),
                save.getPaymentId(),
                save.getAmount(),
                save.getStatus());
    }
}