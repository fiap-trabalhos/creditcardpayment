package br.com.fiap.creditcardpayment.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloSaleResponse(
        @JsonProperty("MerchantOrderId")
        String merchantOrderId,
        @JsonProperty("Customer")
        CieloCustomer customer,
        @JsonProperty("Payment")
        CieloPaymentResponse payment
) {
}