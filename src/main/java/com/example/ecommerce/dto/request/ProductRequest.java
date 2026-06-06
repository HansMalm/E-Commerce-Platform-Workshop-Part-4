package com.example.ecommerce.dto.request;

import java.math.BigDecimal;

public record ProductRequest(
        String name,
        BigDecimal price,
        Long categoryId
) {
}
