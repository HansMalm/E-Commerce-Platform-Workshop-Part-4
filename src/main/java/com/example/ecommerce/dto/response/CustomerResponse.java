package com.example.ecommerce.dto.response;

public record CustomerResponse(
        Long id,
        String fullName,
        String email,
        AddressResponse addressResponse
) {
}
