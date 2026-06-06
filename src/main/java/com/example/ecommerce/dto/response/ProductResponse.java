package com.example.ecommerce.dto.response;

import com.example.ecommerce.entity.Category;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        String categoryName
) {
}
