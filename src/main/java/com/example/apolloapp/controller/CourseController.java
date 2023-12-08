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
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public String getCourseList(Model model){
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        return "courseList";
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

    @PutMapping("/editCourse/{id}")
    public String editCourse(@PathVariable("id") Long id, Model model){
        CourseModel course = courseService.getCourseById(id);
        model.addAttribute("courseModel", course);
        return "editCourse";
        // todo czy powinniśmy dodać też post mapping dla edit? --> zamiana na @Put
    }

    @DeleteMapping("/deleteCourse/{id}")
    public RedirectView deleteCourse(@PathVariable("id") Long id, Model model){
        courseService.deleteCourse(id);
        return new RedirectView("/courses");
        //po usunięciu chcemy wrócić do strony z kursami czy wyświetlić coś innego?
    }

    // stworzenie end-point dla widoku gdzie pokazujemy wszystkie dane o kursie
    // pod button "see more"
    @GetMapping("/courseDetails/{id}")
    public String showCourseDetails(@PathVariable("id")Long id, Model model){
        CourseModel course = courseService.getCourseById(id);
        model.addAttribute("courseModel", course);
        return "courseDetails";
        // request obsłużony @RequestBody?
        // czy pod "getCourseById" umieszczamy wszystkie szczegóły kursu?
    }


}
