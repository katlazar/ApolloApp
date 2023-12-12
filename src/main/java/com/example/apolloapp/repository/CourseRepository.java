package com.example.apolloapp.repository;

import com.example.apolloapp.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {
    CourseModel findByName(String name);

    CourseModel findCourseById(Long courseId);
}
