package com.placement.portal.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    
    private LocalDateTime appliedDate;
    
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    
    private String remarks;
    
    public enum Status {
        PENDING, SHORTLISTED, REJECTED, SELECTED
    }
}
