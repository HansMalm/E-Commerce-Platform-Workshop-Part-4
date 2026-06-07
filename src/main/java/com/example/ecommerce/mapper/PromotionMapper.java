package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.response.PromotionResponse;
import com.example.ecommerce.entity.Promotion;
import org.springframework.stereotype.Component;

@Component
public class PromotionMapper {

    public PromotionResponse toResponse(Promotion promotion){
        if(promotion == null) throw new IllegalArgumentException("Promotion cannot be null!");

        return new PromotionResponse(
                promotion.getId(),
                promotion.getCode(),
                promotion.getStartDate(),
                promotion.getEndDate(),
                promotion.getDiscountPercentage()
        );
    }
}
