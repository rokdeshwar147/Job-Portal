package com.placement.portal.service;

import com.placement.portal.model.Job;
import com.placement.portal.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
    
    public List<Job> getAllActiveJobs() {
        return jobRepository.findByActiveTrue();
    }
    
    public List<Job> getJobsByCompany(Long companyId) {
        return jobRepository.findByCompany_Id(companyId);
    }
    
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
    
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
