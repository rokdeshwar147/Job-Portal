package com.placement.portal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String companyName;
    private String industry;
    private String website;
    private String contactPerson;
    private String phone;
    private String address;
    
    @Column(length = 1000)
    private String description;
}
