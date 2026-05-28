package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table (name = "tbl_promotions")
@Getter
@Setter
public class Promotion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private LocalDate startDate;

    private LocalDate endDate;

}
