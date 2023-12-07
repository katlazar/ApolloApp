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
        courseRepository.save(course);
    }

    public CourseModel getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
        // todo czy tu orElse chcemy żeby zwróciło null? w dokumencacji null jest dopuszczalny
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }


}
