package br.com.fiap.creditcardpayment.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloPaymentRequest(
        @JsonProperty("Type")
        String type,
        @JsonProperty("Amount")
        Integer amount,
        @JsonProperty("Installments")
        Integer installments,
        @JsonProperty("SoftDescriptor")
        String softDescriptor,
        @JsonProperty("CreditCard")
        CieloCreditCard creditCard
) {
}