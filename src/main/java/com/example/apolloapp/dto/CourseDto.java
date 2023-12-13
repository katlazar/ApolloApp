package com.example.apolloapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    private List<Long> moduleId;
}



