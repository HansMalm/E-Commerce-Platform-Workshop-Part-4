package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.CustomerRequest;
import com.example.ecommerce.dto.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse register(CustomerRequest customerRequest);
    CustomerResponse findById(Long id);
    CustomerResponse update(Long id, CustomerRequest customerRequest);
}
