package br.com.fiap.creditcardpayment.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloSaleRequest(
        @JsonProperty("merchantOrderId")
        String MerchantOrderId,
        @JsonProperty("Customer")
        CieloCustomer customer,
        @JsonProperty("Payment")
        CieloPaymentRequest payment
) {
}
