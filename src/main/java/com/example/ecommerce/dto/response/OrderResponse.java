package com.example.ecommerce.dto.response;

import com.example.ecommerce.entity.OrderStatus;

import java.util.List;

public record OrderResponse(
        Long id,
        Integer orderDate,
        OrderStatus orderStatus,
        List<OrderItemResponse> items
) {
}
