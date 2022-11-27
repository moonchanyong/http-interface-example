package com.yahoconut.httpinterfaceexample.dto;

import java.math.BigDecimal;
import java.util.Objects;

public record OrderResult(String orderId, BigDecimal price, int quantity, BigDecimal amount) {
    public OrderResult {
        Objects.requireNonNull(orderId);
        Objects.requireNonNull(price);
        Objects.requireNonNull(quantity);

        if (orderId.isBlank()) throw new IllegalArgumentException("`orderId` is Blank.");
    }
}
