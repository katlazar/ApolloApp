package com.example.apolloapp.service;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    // zwrócenie listy wszytkich kursów
    // chcemy zwrócić tylko przyszłe kursy - czy potrzebujemy dodatkowej logiki?
    public List<CourseModel> getCourseList() {
        return courseRepository.findAll();
    }

    public void addCourse(CourseModel course) {
        if(!courseExists(course)){
            courseRepository.save(course);
        } else{
            throw new RuntimeException("Course with the same name already exist in the data base. Change name.");
        }

    }

    public CourseModel getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course does not exist. Check input"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    private boolean courseExists(CourseModel course){
        CourseModel existingCourse = courseRepository.findByName(course.getName());
        return existingCourse != null;
        // jeżeli nie jest null to kurs już istnieje
    }


}
