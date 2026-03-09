package com.example.controller;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;

import com.example.dto.PolicyRequestDTO;
import com.example.dto.PolicyResponseDTO;
import com.example.service.PolicyService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {

    private  PolicyService policyService;

    // Create Policy
    @PostMapping
    public PolicyResponseDTO createPolicy(@Valid @RequestBody PolicyRequestDTO dto) {
        return policyService.createPolicy(dto);
    }

    // Get Policy by ID
    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicy(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    // Get All Policies with Pagination & Sorting
    @GetMapping
    public Page<PolicyResponseDTO> getPolicies(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        return policyService.getAllPolicies(page, size, sortBy, direction);
    }

    // Cancel Policy
    @DeleteMapping("/{id}")
    public void cancelPolicy(@PathVariable Long id) {
        policyService.cancelPolicy(id);
    }

    // Filter by Policy Type
    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getByType(@PathVariable String type) {
        return policyService.getPoliciesByType(type);
    }

    // Filter by Premium Range
    @GetMapping("/premium")
    public List<PolicyResponseDTO> getByPremium(
            @RequestParam double min,
            @RequestParam double max) {

        return policyService.getPoliciesByPremiumRange(min, max);
    }
}