package com.example.ecommerce.dto.response;

import com.example.ecommerce.entity.OrderStatus;

import java.time.Instant;
import java.util.List;

public record OrderResponse(
        Long id,
        Instant orderDate,
        OrderStatus orderStatus,
        List<OrderItemResponse> items
) {
}
