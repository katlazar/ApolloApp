package com.example.apolloapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("userRoles", SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
       // model.addAttribute("userName", SecurityContextHolder.getContext().getAuthentication().getName()); // DO POPRAWY
        return "home";
    }
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/logout")
    public String getLogout() {
        return "redirect:/login";
    }
}
