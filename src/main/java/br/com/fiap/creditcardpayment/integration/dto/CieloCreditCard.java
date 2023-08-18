package br.com.fiap.creditcardpayment.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloCreditCard(
        @JsonProperty("CardToken")
        String cardToken
) {
}