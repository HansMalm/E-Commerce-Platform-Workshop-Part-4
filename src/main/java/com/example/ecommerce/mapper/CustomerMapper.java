package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.CustomerRequest;
import com.example.ecommerce.dto.response.AddressResponse;
import com.example.ecommerce.dto.response.CustomerResponse;
import com.example.ecommerce.entity.Address;
import com.example.ecommerce.entity.Customer;

public class CustomerMapper {

    public CustomerResponse toResponse(Customer customer){

        AddressResponse addressResponse = null;
        if(customer.getAddress() != null){
            addressResponse = new AddressResponse(
                    customer.getAddress().getId(),
                    customer.getAddress().getStreet(),
                    customer.getAddress().getCity(),
                    customer.getAddress().getZipCode()
            );
        }

        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName()+" "+customer.getLastName(),
                customer.getEmail(),
                addressResponse
        );
    }

    public Customer toEntity(CustomerRequest customerRequest){

        Address address = new Address();
        address.setStreet(customerRequest.street());
        address.setCity(customerRequest.city());
        address.setZipCode(customerRequest.zipCode());

        Customer customer = new Customer();
        customer.setFirstName(customerRequest.firstName());
        customer.setLastName(customerRequest.lastName());
        customer.setEmail(customerRequest.email());
        customer.setAddress(address);
        return customer;
    }

}
