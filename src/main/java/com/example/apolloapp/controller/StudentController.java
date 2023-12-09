package com.example.apolloapp.controller;

import com.example.apolloapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final UserService userService;

    @GetMapping("/student")
    public String getAdmin(Model model) {
        model.addAttribute("userObject", userService.getCurrentlyLoggedUser());
        return "studentPanel";
    }
}
