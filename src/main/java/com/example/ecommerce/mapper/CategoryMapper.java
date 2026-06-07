package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.response.CategoryResponse;
import com.example.ecommerce.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category){
        if(category == null) throw new IllegalArgumentException("Category cannot be null!");

        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }

}
