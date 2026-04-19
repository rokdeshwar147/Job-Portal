package com.placement.portal.controller;

import com.placement.portal.model.Application;
import com.placement.portal.service.ApplicationService;
import com.placement.portal.service.StudentService;
import com.placement.portal.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {
    
    private final ApplicationService applicationService;
    private final StudentService studentService;
    private final JobService jobService;
    
    @GetMapping
    public String listApplications(Model model) {
        model.addAttribute("applications", java.util.Collections.emptyList());
        return "applications";
    }
    
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("application", new Application());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("jobs", jobService.getAllJobs());
        model.addAttribute("statuses", Application.Status.values());
        return "application-form";
    }
    
    @PostMapping
    public String saveApplication(@ModelAttribute Application application, RedirectAttributes redirectAttributes) {
        try {
            if (application.getAppliedDate() == null) {
                application.setAppliedDate(LocalDateTime.now());
            }
            applicationService.saveApplication(application);
            redirectAttributes.addFlashAttribute("success", "Application saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error saving application: " + e.getMessage());
        }
        return "redirect:/applications";
    }
    
    @GetMapping("/{id}")
    public String viewApplication(@PathVariable Long id, Model model) {
        Application application = applicationService.getApplicationById(id);
        if (application == null) {
            return "redirect:/applications";
        }
        model.addAttribute("application", application);
        return "application-view";
    }
    
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Application application = applicationService.getApplicationById(id);
        if (application == null) {
            return "redirect:/applications";
        }
        model.addAttribute("application", application);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("jobs", jobService.getAllJobs());
        model.addAttribute("statuses", Application.Status.values());
        return "application-form";
    }
    
    @PostMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam Application.Status status, 
                              @RequestParam(required = false) String remarks, RedirectAttributes redirectAttributes) {
        try {
            Application application = applicationService.getApplicationById(id);
            if (application != null) {
                application.setStatus(status);
                if (remarks != null && !remarks.trim().isEmpty()) {
                    application.setRemarks(remarks);
                }
                applicationService.saveApplication(application);
                redirectAttributes.addFlashAttribute("success", "Application status updated successfully!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating status: " + e.getMessage());
        }
        return "redirect:/applications";
    }
}