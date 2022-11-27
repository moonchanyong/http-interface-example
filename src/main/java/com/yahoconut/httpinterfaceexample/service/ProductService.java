package com.yahoconut.httpinterfaceexample.service;


import com.yahoconut.httpinterfaceexample.HttpExchangeInterface;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PutExchange;

@HttpExchangeInterface
public interface ProductService  {
    @PutExchange("/product/decrease/{productId}")
    void decreaseQuantity(@PathVariable String productId, @RequestParam int quantity);
}
