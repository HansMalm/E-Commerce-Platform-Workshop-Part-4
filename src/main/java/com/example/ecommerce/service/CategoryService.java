package com.example.ecommerce.service;

import com.example.ecommerce.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(String name);
    List<CategoryResponse> findAll();
}
