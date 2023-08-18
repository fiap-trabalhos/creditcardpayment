package br.com.fiap.creditcardpayment.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloPaymentResponse(
        @JsonProperty("ServiceTaxAmount")
        Integer serviceTaxAmount,
        @JsonProperty("Installments")
        Integer installments,
        @JsonProperty("Interest")
        String interest,
        @JsonProperty("Capture")
        Boolean capture,
        @JsonProperty("Authenticate")
        Boolean authenticate,
        @JsonProperty("CreditCard")
        CieloCreditCard creditCard,
        @JsonProperty("ProofOfSale")
        String proofOfSale,
        @JsonProperty("Tid")
        String tid,
        @JsonProperty("AuthorizationCode")
        String authorizationCode,
        @JsonProperty("SoftDescriptor")
        String softDescriptor,
        @JsonProperty("PaymentId")
        String paymentId,
        @JsonProperty("Type")
        String type,
        @JsonProperty("Amount")
        Integer amount,
        @JsonProperty("Currency")
        String currency,
        @JsonProperty("Country")
        String country,
        @JsonProperty("Status")
        Integer status
) {
}