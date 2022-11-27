package com.yahoconut.httpinterfaceexample.service;

import com.yahoconut.httpinterfaceexample.HttpExchangeInterface;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PutExchange;

import java.math.BigDecimal;
@HttpExchangeInterface
public interface PaymentService {
    @PutExchange("/payment")
    void payAmount(@RequestParam BigDecimal amount);
}
