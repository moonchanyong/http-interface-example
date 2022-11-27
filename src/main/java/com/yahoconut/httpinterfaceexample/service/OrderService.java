package com.yahoconut.httpinterfaceexample.service;

import com.yahoconut.httpinterfaceexample.dto.OrderResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {

    private ProductService productService;
    private PaymentService paymentService;

    public OrderService(ProductService productService, PaymentService paymentService) {
        this.productService = productService;
        this.paymentService = paymentService;
    }

    // not atomic operation.
    public OrderResult createOrder(String productId, BigDecimal price, int quantity) {
        try {
            productService.decreaseQuantity(productId, quantity);
        } catch(Throwable t) {
            System.out.println(t);
        }
        paymentService.payAmount(price.multiply(BigDecimal.valueOf(quantity)));

        // save order..
        final String orderId = UUID.randomUUID().toString();

        return new OrderResult(
                orderId,
                price,
                quantity,
                price.multiply(BigDecimal.valueOf(quantity))
        );
    }
}
