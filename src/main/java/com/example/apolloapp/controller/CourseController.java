package com.example.apolloapp.controller;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.repository.CourseRepository;
import com.example.apolloapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    // dodanie pierwszego widoku z listą kursów (Kasia Ł. ---> dodaje listę kursów w bazie)
    @GetMapping("/courses")
    public String getCourseList(Model model){
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        return "courses/courses";
        // nie pamiętam dlaczego mamy podwójnie courses? ---> dlatego że z button courses wchodzimy w właściwą listę kursów / widok kursó?
    }


}
