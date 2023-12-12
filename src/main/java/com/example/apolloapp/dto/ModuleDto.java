package com.example.apolloapp.dto;

import com.example.apolloapp.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ModuleDto {

    private Long id;
    private String subject;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer totalHours;
}
