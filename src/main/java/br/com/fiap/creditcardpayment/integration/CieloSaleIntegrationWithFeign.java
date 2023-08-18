package br.com.fiap.creditcardpayment.integration;

import br.com.fiap.creditcardpayment.configuration.FeignConfiguration;
import br.com.fiap.creditcardpayment.integration.dto.CieloSaleRequest;
import br.com.fiap.creditcardpayment.integration.dto.CieloSaleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "CieloSale",
        url = "${cielo.sale.url}",
        configuration = FeignConfiguration.class
)
public interface CieloSaleIntegrationWithFeign {
    @PostMapping(
            path = "/1/sales/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    CieloSaleResponse sale(
            @RequestHeader("MerchantId") final String merchantId,
            @RequestHeader("MerchantKey") final String merchantKey,
            @RequestBody final CieloSaleRequest request);
}
