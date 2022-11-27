package com.yahoconut.httpinterfaceexample.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {
    @PutMapping("/decrease/{productId}")
    public void decreaseProductItemNumber(@PathVariable String productId, @RequestParam int quantity) {
        // saveDB
        // Assure transaction always success.
        System.out.println("""
                decreaseProductItemNumber
                productId: %s
                quantity: %d""".formatted(productId, quantity)
        );

        throw new IllegalArgumentException("그냥");
    }
}
