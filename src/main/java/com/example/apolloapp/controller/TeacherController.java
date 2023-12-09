package com.example.apolloapp.controller;

import com.example.apolloapp.model.ModuleModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.service.ModuleService;
import com.example.apolloapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeacherController {

    private final UserService userService;
    private final ModuleService moduleService;

    @GetMapping("/teacher")
    public String getAdmin(Model model) {
        model.addAttribute("userObject", userService.getCurrentlyLoggedUser());
        return "teacherPanel";
    }

    // dodanie teacher do konkretnego modułu
    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        List<ModuleModel> list = moduleService.getModuleList();
        model.addAttribute("moduleModel", list);
        return "addTeacher";
    }

    // zapis teacher w repozytorium user z powrotem na widok modułów bo teacher jest przypisywany do modułu z panelu admina
    // więc chcemy wrócićna stronę wyjściową edycji modułów
    @PostMapping("/addTeacher")
    public RedirectView postAddTeacher(UserModel module){
        userService.addUser(module);
        return new RedirectView("/modules");
    }

}
