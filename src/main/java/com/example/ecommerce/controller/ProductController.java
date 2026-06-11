package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.ProductRequest;
import com.example.ecommerce.dto.response.ProductResponse;
import com.example.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    // POST /api/vi/products :  Create a new product
    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @Valid @RequestBody ProductRequest request) {
        ProductResponse response = productService.create(request);

        // Return 201 Created with the created product
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get /api/vi/products :  Get all products
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    // GET /api/vi/products/search?name=...  :  Search products by name
    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchByName(
            @RequestParam String name ) {
        List<ProductResponse> results = productService.searchByName(name);
        return ResponseEntity.ok(results);
    }

    // Get /api/v1/products/{id} :  Find product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        ProductResponse response = productService.findById(id);
        return ResponseEntity.ok(response);
    }

    // PUT avi/v1/products/{id} :  Update product
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        ProductResponse updated = productService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/v1/products{id} : Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);

        // 204 No Content = successful delete
        return ResponseEntity.noContent().build();
    }


}
