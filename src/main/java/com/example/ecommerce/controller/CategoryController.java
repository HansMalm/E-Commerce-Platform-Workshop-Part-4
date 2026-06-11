package com.example.ecommerce.controller;

import com.example.ecommerce.dto.response.CategoryResponse;
import com.example.ecommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//POST: Create a new category. Status: 201 Created.
//GET: List all categories. Status: 200 OK.

@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(request));
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>>findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }



}
