package com.example.controller;

import com.example.dto.CustomerRequestDTO;
import com.example.dto.CustomerResponseDTO;
import com.example.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private  CustomerService customerService;

    public CustomerController(CustomerService customerService) {
    	this.customerService=customerService;
    }
    // Create Customer
    @PostMapping
    public CustomerResponseDTO createCustomer(@Valid @RequestBody CustomerRequestDTO dto) {
        return customerService.createCustomer(dto);
    }

    // Get All Customers
    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get Customer By ID
    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
}

