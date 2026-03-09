package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.dto.*;
import com.example.entity.*;
import com.example.repository.*;
import com.example.mapper.*;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService {

    private  PolicyRepository policyRepo;
    private  CustomerRepository customerRepo;

    @Override
    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {

        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Policy policy = new Policy();

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setStatus("ACTIVE");
        policy.setCustomer(customer);

        policyRepo.save(policy);

        return PolicyMapper.toDTO(policy);
    }

    @Override
    public PolicyResponseDTO getPolicyById(Long id) {

        Policy policy = policyRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        return PolicyMapper.toDTO(policy);
    }

    @Override
    public Page<PolicyResponseDTO> getAllPolicies(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return policyRepo.findAll(pageable)
                .map(PolicyMapper::toDTO);
    }

    @Override
    public void cancelPolicy(Long id) {

        Policy policy = policyRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepo.save(policy);
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        return policyRepo.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {

        return policyRepo.findByPremiumAmountBetween(min, max)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }
}