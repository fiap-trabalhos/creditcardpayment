package br.com.fiap.creditcardpayment.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CieloCustomer(
        @JsonProperty("Name")
        String name
) {
}