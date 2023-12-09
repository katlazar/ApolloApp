package com.example.apolloapp.controller;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CourseService courseService;

    @GetMapping("/")
    public String getMainPage() {
        return "redirect:/home";
    }

    @GetMapping("/test")
    public String getTest(Model model) {
        model.addAttribute("userRoles", "ADMIN");
        model.addAttribute("userName", "Admin");
        return "test";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("userRoles", authentication.getAuthorities().toString());
        model.addAttribute("userName", authentication.getName());

        List<CourseModel> list = courseService.getCourseList();
        int numberOfCourses = list.size();
        int courseIndex = new Random().nextInt(numberOfCourses);

        model.addAttribute("courseModel1", list.get(courseIndex));
        courseIndex = (courseIndex+1) % (numberOfCourses);
        model.addAttribute("courseModel2", list.get(courseIndex));
        courseIndex = (courseIndex+1) % (numberOfCourses);
        model.addAttribute("courseModel3", list.get(courseIndex));
        return "home";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

//    @GetMapping("/admin")
//    public String getAdmin() {
//        return "admin";
//    }

    @GetMapping("/logout")
    public String getLogout() {
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }
}
