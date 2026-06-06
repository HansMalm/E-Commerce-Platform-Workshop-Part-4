package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.request.OrderItemRequest;
import com.example.ecommerce.dto.request.OrderRequest;
import com.example.ecommerce.dto.response.OrderResponse;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.mapper.OrderMapper;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.OrderService;
import org.antlr.v4.runtime.RecognitionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        if (orderRequest == null) throw new IllegalArgumentException("OrderRequest cannot be null!");

        // Find the customer
        Customer customer = customerRepository.findById(orderRequest.customerId())
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found with id "+orderRequest.customerId()));

        // Find the Product for each requested item
        List<Product> products = productRepository.findAllById(
                orderRequest.items().stream()
                        .map(OrderItemRequest::productId)
                        .toList()
        );

        Map<Long, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, p -> p));

        // Apply any active Promotions (optional).
        // Save the Order with its items.
        Order order = orderMapper.toEntity(orderRequest, customer, productMap);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }
}
