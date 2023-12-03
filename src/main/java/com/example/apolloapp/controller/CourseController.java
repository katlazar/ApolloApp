package com.example.apolloapp.controller;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.repository.CourseRepository;
import com.example.apolloapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping(value = "/cars", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CourseController {

    private final CourseService courseService;

    // dodanie pierwszego widoku z listą kursów (Kasia Ł. ---> dodaje listę kursów w bazie)
    @GetMapping("/courses")
    public String getCourseList(Model model){
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        return "courseList";
        //ze strony głównej nie przełącza na Courses
    }


}
