package com.example.apolloapp.repository;


import com.example.apolloapp.model.EnrollmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<EnrollmentModel, Long> {
}
