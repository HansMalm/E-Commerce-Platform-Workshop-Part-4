package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.request.CustomerRequest;
import com.example.ecommerce.dto.response.CustomerResponse;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.mapper.CustomerMapper;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    @Transactional
    public CustomerResponse register(CustomerRequest customerRequest) {
        if(customerRequest == null) throw new IllegalArgumentException("CustomerRequest cannot be null");
        Customer customer = customerMapper.toEntity(customerRequest);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponse findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public CustomerResponse update(Long id, CustomerRequest customerRequest) {
        return null;
    }
}
