package com.example.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "tbl_order_items")
public class OrderItem {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private BigDecimal priceAtPurchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
