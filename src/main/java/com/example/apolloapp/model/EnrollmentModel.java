package com.example.apolloapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Table(name="enrollment")
public class EnrollmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    @Column(name="creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @Column(name="payment_status")
    private Boolean paymentStatus;

    @Column(name="course_price")
    private Double coursePrice;
}
