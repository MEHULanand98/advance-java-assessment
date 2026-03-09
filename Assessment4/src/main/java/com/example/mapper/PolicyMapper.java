package com.example.mapper;

import com.example.dto.PolicyResponseDTO;
import com.example.entity.Policy;

public class PolicyMapper {

public static PolicyResponseDTO toDTO(Policy p){

PolicyResponseDTO dto = new PolicyResponseDTO();

dto.setId((Long) p.getId());
dto.setPolicyNumber(p.getPolicyNumber());
dto.setPolicyType(p.getPolicyType());
dto.setPremiumAmount(p.getPremiumAmount());
dto.setCoverageAmount(p.getCoverageAmount());
dto.setStartDate(p.getStartDate());
dto.setEndDate(p.getEndDate());
dto.setStatus(p.getStatus());

dto.setCustomer(CustomerMapper.toDTO(p.getCustomer()));

return dto;
}
}
