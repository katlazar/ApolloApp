package com.example.apolloapp.model;

/*
 * id
 * subject
 * user_id (dotyczy instructor ---> czy  instructor_id )
 * start_date
 * end_date
 * total_hours
 */

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name = "module")
public class ModuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "total_hours")
    private Integer totalHours;

}