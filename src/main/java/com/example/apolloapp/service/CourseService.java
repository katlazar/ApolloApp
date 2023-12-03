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
}
