package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.OrderRequest;
import com.example.ecommerce.dto.response.OrderItemResponse;
import com.example.ecommerce.dto.response.OrderResponse;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    private final ProductMapper productMapper;

    public OrderMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderResponse toResponse(Order order){
        List<OrderItemResponse> items =
                order.getItems()
                        .stream()
                        .map(this::toOrderItemResponse)
                        .toList();

        return new OrderResponse(
                order.getId(),
                order.getOrderDate(),
                order.getStatus(),
                items
        );
    }

    private OrderItemResponse toOrderItemResponse(OrderItem item) {

        return new OrderItemResponse(
                item.getId(),
                item.getQuantity(),
                item.getPriceAtPurchase(),
                productMapper.toResponse(item.getProduct())
        );
    }

    public Order toEntity(OrderRequest orderRequest, Customer customer){
        if(orderRequest == null) throw new IllegalArgumentException("Order Request cannot be null!");

        Order order = new Order();
        order.setCustomer(customer);
        return order;
    }
}
