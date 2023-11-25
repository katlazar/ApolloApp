package com.example.apolloapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "course")
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @Column(name = "type")
    private String type;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_hours")
    private int totalHours;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "enroll")
    private int enroll;

// czy przypadkiem te dwie funkcjonalnosci nie powinny byc robione w nowej kalsie?
// np. CourseAvailability

}
