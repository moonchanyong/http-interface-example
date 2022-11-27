package com.yahoconut.httpinterfaceexample.controller;

import com.yahoconut.httpinterfaceexample.dto.OrderRequest;
import com.yahoconut.httpinterfaceexample.dto.OrderResult;
import com.yahoconut.httpinterfaceexample.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController{

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResult createOrder(@RequestBody OrderRequest req) {
        return orderService.createOrder(
                req.productId(),
                req.price(),
                req.quantity()
        );
    }
}
