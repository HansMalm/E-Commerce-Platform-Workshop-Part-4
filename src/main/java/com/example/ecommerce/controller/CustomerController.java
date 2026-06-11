package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.CustomerRequest;
import com.example.ecommerce.dto.response.CustomerResponse;
import com.example.ecommerce.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customer Controller", description = "APIs for managing customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "Create a new customer")
    public ResponseEntity<CustomerResponse> register(@Valid @RequestBody CustomerRequest customerRequest){
        IO.println("Request body: "+customerRequest);

        CustomerResponse customerResponse = customerService.register(customerRequest);
        IO.println("Response body: "+ customerResponse);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a customer")
    public ResponseEntity<CustomerResponse> findById(@PathVariable @Positive Long id){
        IO.println("Id: "+id);

        CustomerResponse customerResponse = customerService.findById(id);
        IO.println("Response body: "+customerResponse);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing customer")
    public  ResponseEntity<CustomerResponse> update(@PathVariable Long id, @Valid @RequestBody CustomerRequest customerRequest){
        IO.println("Id: "+id);

        CustomerResponse customerResponse = customerService.update(id, customerRequest);
        IO.println("Response body: "+customerResponse);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerResponse);
    }
}
