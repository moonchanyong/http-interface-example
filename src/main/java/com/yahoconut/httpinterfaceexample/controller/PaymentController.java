package com.yahoconut.httpinterfaceexample.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("/payment")
@RestController
public class PaymentController {
    @PutMapping
    public void payAmount(@RequestParam BigDecimal amount) {
        // saveDB
        // Assure transaction always success.
        System.out.println("""
            payAmount 
            amount: %s""".formatted(amount.toString())
        );
    }
}
