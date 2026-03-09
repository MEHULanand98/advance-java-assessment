package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
