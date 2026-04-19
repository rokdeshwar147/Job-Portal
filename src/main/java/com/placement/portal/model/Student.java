package com.placement.portal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String rollNumber;
    private String department;
    private String degree;
    private Integer graduationYear;
    private Double cgpa;
    private String phone;
    private String skills;
    private String resumePath;
}
