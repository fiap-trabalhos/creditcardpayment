package br.com.fiap.creditcardpayment.entity;

public record SaleResponse(
        String merchantOrderId,
        String paymentId,
        Integer value,
        Integer status
) {
}