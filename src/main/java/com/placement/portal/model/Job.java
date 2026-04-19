package com.placement.portal.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    
    private String title;
    private String location;
    private String jobType;
    private Double salary;
    private String eligibilityCriteria;
    
    @Column(length = 2000)
    private String description;
    
    private LocalDate postedDate;
    private LocalDate deadline;
    private boolean active = true;
}
