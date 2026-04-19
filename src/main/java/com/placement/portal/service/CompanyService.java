package com.placement.portal.service;

import com.placement.portal.model.Company;
import com.placement.portal.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
    
    public Company getCompanyByUserId(Long userId) {
        return companyRepository.findByUser_Id(userId).orElse(null);
    }
    
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
