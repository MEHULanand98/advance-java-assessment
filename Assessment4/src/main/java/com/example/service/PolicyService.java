package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dto.*;

public interface PolicyService {

PolicyResponseDTO createPolicy(PolicyRequestDTO dto);

PolicyResponseDTO getPolicyById(Long id);

Page<PolicyResponseDTO> getAllPolicies(int page,int size,String sortBy,String direction);

void cancelPolicy(Long id);

List<PolicyResponseDTO> getPoliciesByType(String type);

List<PolicyResponseDTO> getPoliciesByPremiumRange(double min,double max);

}
