package com.placement.portal.config;

import com.placement.portal.model.*;
import com.placement.portal.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    
    private final UserService userService;
    private final StudentService studentService;
    private final CompanyService companyService;
    private final JobService jobService;
    private final ApplicationService applicationService;
    
    @Override
    public void run(String... args) throws Exception {
        // Temporarily disabled to debug
        // if (userService.getAllUsers().isEmpty()) {
        //     initializeData();
        // }
    }
    
    private void initializeData() {
        try {
            // Create Users
            User user1 = new User(null, "john.doe@student.edu", "password", "John Doe", User.Role.STUDENT, true);
            User user2 = new User(null, "jane.smith@student.edu", "password", "Jane Smith", User.Role.STUDENT, true);
            User user3 = new User(null, "mike.wilson@student.edu", "password", "Mike Wilson", User.Role.STUDENT, true);
            User user4 = new User(null, "sarah.johnson@student.edu", "password", "Sarah Johnson", User.Role.STUDENT, true);
            User user5 = new User(null, "alex.brown@student.edu", "password", "Alex Brown", User.Role.STUDENT, true);
            
            User companyUser1 = new User(null, "hr@techcorp.com", "password", "TechCorp HR", User.Role.COMPANY, true);
            User companyUser2 = new User(null, "hr@innovate.com", "password", "Innovate Solutions HR", User.Role.COMPANY, true);
            
            user1 = userService.saveUser(user1);
            user2 = userService.saveUser(user2);
            user3 = userService.saveUser(user3);
            user4 = userService.saveUser(user4);
            user5 = userService.saveUser(user5);
            companyUser1 = userService.saveUser(companyUser1);
            companyUser2 = userService.saveUser(companyUser2);
            
            // Create Students
            Student student1 = new Student(null, user1, "CS2021001", "Computer Science", "B.Tech", 2024, 8.5, "+1-555-0101", "Java, Spring Boot, React", null);
            Student student2 = new Student(null, user2, "IT2021002", "Information Technology", "B.Tech", 2024, 9.2, "+1-555-0102", "Python, Django, Machine Learning", null);
            Student student3 = new Student(null, user3, "EC2021003", "Electronics", "B.Tech", 2025, 7.8, "+1-555-0103", "C++, Embedded Systems, IoT", null);
            Student student4 = new Student(null, user4, "ME2021004", "Mechanical", "B.Tech", 2024, 8.1, "+1-555-0104", "CAD, SolidWorks, Project Management", null);
            Student student5 = new Student(null, user5, "CS2020005", "Computer Science", "B.Tech", 2024, 9.0, "+1-555-0105", "JavaScript, Node.js, MongoDB", null);
            
            student1 = studentService.saveStudent(student1);
            student2 = studentService.saveStudent(student2);
            student3 = studentService.saveStudent(student3);
            student4 = studentService.saveStudent(student4);
            student5 = studentService.saveStudent(student5);
            
            // Create Companies
            Company company1 = new Company(null, companyUser1, "TechCorp", "Technology", "www.techcorp.com", "John Manager", "+1-555-1001", "San Francisco, CA", "Leading software development company");
            Company company2 = new Company(null, companyUser2, "Innovate Solutions", "Consulting", "www.innovatesolutions.com", "Jane Director", "+1-555-1002", "New York, NY", "Digital transformation consultancy");
            
            company1 = companyService.saveCompany(company1);
            company2 = companyService.saveCompany(company2);
            
            // Create Jobs
            Job job1 = new Job(null, company1, "Software Developer", "San Francisco, CA", "Full-time", 75000.0, "Bachelor's degree in CS", "Full-time software development role", LocalDate.now().minusDays(10), LocalDate.now().plusDays(20), true);
            Job job2 = new Job(null, company1, "Frontend Developer", "San Francisco, CA", "Full-time", 70000.0, "Experience with React", "React.js frontend development", LocalDate.now().minusDays(5), LocalDate.now().plusDays(25), true);
            Job job3 = new Job(null, company2, "Data Analyst", "New York, NY", "Full-time", 65000.0, "Python, SQL knowledge", "Analyze business data and create insights", LocalDate.now().minusDays(7), LocalDate.now().plusDays(15), true);
            
            job1 = jobService.saveJob(job1);
            job2 = jobService.saveJob(job2);
            job3 = jobService.saveJob(job3);
            
            // Create Applications
            Application app1 = new Application(null, student1, job1, LocalDateTime.now().minusDays(3), Application.Status.SHORTLISTED, "Good technical skills");
            Application app2 = new Application(null, student2, job3, LocalDateTime.now().minusDays(2), Application.Status.SELECTED, "Excellent Python skills and data analysis experience");
            Application app3 = new Application(null, student5, job2, LocalDateTime.now().minusDays(1), Application.Status.PENDING, null);
            Application app4 = new Application(null, student4, job1, LocalDateTime.now().minusDays(4), Application.Status.REJECTED, "Not a good fit for the role");
            Application app5 = new Application(null, student3, job1, LocalDateTime.now().minusDays(1), Application.Status.PENDING, null);
            
            applicationService.saveApplication(app1);
            applicationService.saveApplication(app2);
            applicationService.saveApplication(app3);
            applicationService.saveApplication(app4);
            applicationService.saveApplication(app5);
        } catch (Exception e) {
            System.err.println("Error initializing data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}