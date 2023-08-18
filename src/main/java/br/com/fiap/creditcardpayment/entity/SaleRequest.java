package br.com.fiap.creditcardpayment.entity;

public record SaleRequest(
        String customerName,
        Integer amount,
        String cardToken
) {
}