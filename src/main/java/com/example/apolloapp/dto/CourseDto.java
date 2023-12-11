package com.example.apolloapp.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CourseDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal basePrice;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalHours;
    private int capacity;
    private int enroll;

}
