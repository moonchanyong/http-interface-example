package com.yahoconut.httpinterfaceexample.dto;

import java.math.BigDecimal;

public record OrderRequest(String productId, BigDecimal price, int quantity){}
