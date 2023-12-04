package com.example.apolloapp.controller;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("/addCourse")
    public String getAddCourse(Model model) {
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public RedirectView postAddCourse(CourseModel course){
        courseService.addCourse(course);
        return new RedirectView("/courses");
    }

    @GetMapping("/editCourse/{id}")
    public String editCourse(@PathVariable("id") Long id, Model model){
        CourseModel course = courseService.getCourseById(id);
        model.addAttribute("courseModel", course);
        return "editCourse";
    }

    @PostMapping("/deleteCourse/{id}")
    public RedirectView deleteCourse(@PathVariable("id") Long id, Model model){
        courseService.deleteCourse(id);
        return new RedirectView("/courses");
        //po usunięciu chcemy wrócić do strony z kursami czy wyświetlić coś innego?
    }

    @GetMapping("/courseDetails/{id}")
    public String showCourseDetails(@PathVariable("id")Long id, Model model){
        courseService.getCourseById(id);
        return "courseDetails";
        // czy pod "getCourseById" umieszczamy wszystkie szczegóły kursu?
    }


}
