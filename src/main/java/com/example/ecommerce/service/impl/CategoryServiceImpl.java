package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.response.CategoryResponse;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.exception.CategoryAlreadyExistsException;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional
    public CategoryResponse create(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Category name cannot be null!");

        // Create a new category after checking if it already exists
        if(categoryRepository.existsByNameIgnoreCase(name)){
            throw new CategoryAlreadyExistsException("Category already exists!");
        }

        Category category = new Category();
        category.setName(name);

        return categoryMapper.toResponse(
                categoryRepository.save(category)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
