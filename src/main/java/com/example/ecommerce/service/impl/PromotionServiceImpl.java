package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.response.PromotionResponse;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Promotion;
import com.example.ecommerce.mapper.PromotionMapper;
import com.example.ecommerce.repository.PromotionRepository;
import com.example.ecommerce.service.PromotionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final PromotionMapper promotionMapper;

    public PromotionServiceImpl(PromotionRepository promotionRepository, PromotionMapper promotionMapper) {
        this.promotionRepository = promotionRepository;
        this.promotionMapper = promotionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PromotionResponse> getActivePromotions() {
        return promotionRepository.findActiveToday()
                .stream()
                .map(promotionMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal calculateDiscount(Product product) {
        if(product == null) throw new IllegalArgumentException("Product cannot be null!");

        BigDecimal price = product.getPrice();

        BigDecimal maxDiscountPercentage = product.getPromotions()
                .stream()
                .filter(p ->
                        !p.getStartDate().isAfter(LocalDate.now()) &&
                                !p.getEndDate().isBefore(LocalDate.now())
                )
                .map(Promotion::getDiscountPercentage)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        return price.multiply(maxDiscountPercentage)
                .divide(BigDecimal.valueOf(100));
    }
}
