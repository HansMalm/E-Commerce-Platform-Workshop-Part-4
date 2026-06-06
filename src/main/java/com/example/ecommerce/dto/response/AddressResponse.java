package com.example.ecommerce.dto.response;

public record AddressResponse(
        Long id,
        String street,
        String city,
        String zipCode
) {
}
