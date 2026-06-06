package com.example.ecommerce.dto.response;

import java.math.BigDecimal;

public record OrderItemResponse(
        Long id,
        Integer quantity,
        BigDecimal priceAtPurchase,
        ProductResponse product
) {
}
