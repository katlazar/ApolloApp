package com.example.apolloapp.controller;

import com.example.apolloapp.dto.CourseDto;
import com.example.apolloapp.dto.ModuleDto;
import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.model.ModuleModel;
import com.example.apolloapp.service.CourseService;
import com.example.apolloapp.service.ModuleService;
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
    private final ModuleService moduleService;

    @GetMapping("/addCourse")
    public String getAddCourse(Model model) {
        List<ModuleModel> list = moduleService.getModuleList();
        model.addAttribute("moduleModel", list);
        return "add-new-course";
    }

    @GetMapping("/courses")
    public String getCourseList(Model model) {
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        return "courseList";
    }

    // zapis modułu w repozytorium kursów (odwołanie do całego obiektu poprzez @RequestBody)
    @PostMapping("/addCourse")
    public RedirectView postAddCourse(CourseDto courseDto) {
        courseService.addCourse(courseDto);
        return new RedirectView("/a-courses");
    }

//    @DeleteMapping("/deleteCourse/{id}")
//    public RedirectView deleteCourse(@PathVariable("id") Long id) {
//        courseService.deleteCourse(id);
//        return new RedirectView("/a-courses");
//        //po usunięciu chcemy wrócić do strony z kursami czy wyświetlić coś innego?
//    }


    @GetMapping("/courseDetails/{id}")
    public String showCourseDetails(@PathVariable("id") Long id, Model model) {
        CourseModel course = courseService.getCourseById(id);
        model.addAttribute("courseModel", course);
        return "details-course";
    }
//usuniecie klamerki
    @GetMapping("/editCourse/{id}")
    public String getEditCourse(@PathVariable("id") Long id, Model model) {
        CourseModel course = courseService.getCourseById(id);
        model.addAttribute("courseModel", course);
        List<ModuleModel> modules = moduleService.getModuleList();
        model.addAttribute("modules", modules);
        return "edit-course";
    }

    @PostMapping("/deleteCourse/{id}")
    public RedirectView deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new RedirectView("/a-courses");
    }

    @PostMapping("/editCourse")
    public RedirectView editCourse(CourseDto courseDto) {
        courseService.saveEditedCourse(courseDto);
        return new RedirectView("/a-courses");
    }

}
