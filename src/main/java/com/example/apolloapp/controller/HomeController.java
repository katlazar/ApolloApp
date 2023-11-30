package com.example.apolloapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomeWithLogin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Pobranie nazwy zalogowanego użytkownika
        String username = authentication.getName();

        // Pobranie ról zalogowanego użytkownika
        String userRoles = authentication.getAuthorities().toString();

        model.addAttribute("userRoles", userRoles);
        model.addAttribute("userName", username);  // Dodanie nazwy użytkownika do modelu

        return "home";
    }

    @GetMapping("/test")
    public String getTest(Model model) {
        model.addAttribute("userRoles", "ADMIN");
        model.addAttribute("userName", "Admin");
        return "test";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("userRoles", "");
        model.addAttribute("userName", "");
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
