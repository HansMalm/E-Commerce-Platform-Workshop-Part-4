package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "tbl_orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant orderDate;

    private OrderStatus status;

    // Unidirectional One-to-One (Customer)
    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<OrderItem> items = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.orderDate = Instant.now();
    }
}
