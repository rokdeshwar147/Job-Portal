package com.placement.portal.service;

import com.placement.portal.model.Application;
import com.placement.portal.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    
    public Application applyForJob(Application application) {
        application.setAppliedDate(LocalDateTime.now());
        return applicationRepository.save(application);
    }
    
    public List<Application> getApplicationsByStudent(Long studentId) {
        return applicationRepository.findByStudent_Id(studentId);
    }
    
    public List<Application> getApplicationsByJob(Long jobId) {
        return applicationRepository.findByJob_Id(jobId);
    }
    
    public boolean hasApplied(Long studentId, Long jobId) {
        return applicationRepository.existsByStudent_IdAndJob_Id(studentId, jobId);
    }
    
    public Application updateApplicationStatus(Long id, Application.Status status, String remarks) {
        Application app = applicationRepository.findById(id).orElse(null);
        if (app != null) {
            app.setStatus(status);
            app.setRemarks(remarks);
            return applicationRepository.save(app);
        }
        return null;
    }
    
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }
    
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }
}
