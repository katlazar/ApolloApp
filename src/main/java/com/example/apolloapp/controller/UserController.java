package com.example.apolloapp.controller;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.service.CourseService;
import com.example.apolloapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CourseService courseService;


    // do edycji wszystkich users (ADMIN / STUDENT / TEACHER)
    @PutMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        UserModel user = userService.getUserById(id);
        model.addAttribute("userModel", user);
        return "editUser";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult, Model model) {
        try {
            userService.addUser(userModel);
            return "login";
        } catch (RuntimeException e) {
            bindingResult.rejectValue("username", "error.userModel", "Użytkownik o tej nazwie lub e-mail już istnieje!");
            model.addAttribute("userModel", userModel);
            return "registration";
        }
    }

    @GetMapping("/enrollment")
    public String addEnrollment(@RequestParam("id") Long courseId, Model model) {
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        model.addAttribute("courseName", userService.addEnrollmentForUser(courseId));
        return "courseList";
    }
}
