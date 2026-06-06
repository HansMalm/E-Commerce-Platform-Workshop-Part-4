package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.OrderItemRequest;
import com.example.ecommerce.dto.request.OrderRequest;
import com.example.ecommerce.dto.response.OrderItemResponse;
import com.example.ecommerce.dto.response.OrderResponse;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

    public Order toEntity(OrderRequest request,
                          Customer customer,
                          Map<Long, Product> productMap) {

        Order order = new Order();
        order.setCustomer(customer);

        List<OrderItem> items = request.items()
                .stream()
                .map(itemReq -> toOrderItem(itemReq, productMap.get(itemReq.productId())))
                .toList();

        order.setItems(items);

        return order;
    }

    private OrderItem toOrderItem(OrderItemRequest req, Product product) {

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(req.quantity());
        // Capture the current price of the product as priceAtPurchase.
        item.setPriceAtPurchase(product.getPrice());

        return item;
    }
}
