package com.example.ecommerce.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PromotionResponse(
    Long id,
    String code,
    LocalDate startDate,
    LocalDate endDate,
    BigDecimal discountPercentage
    ){
}
