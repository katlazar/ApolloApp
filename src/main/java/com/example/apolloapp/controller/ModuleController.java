package com.example.apolloapp.controller;

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
public class ModuleController {

    private final ModuleService moduleService;
    private final CourseService courseService;


    // dodanie modułu do konkretnego kursu
    @GetMapping("/addModule")
    public String addModule(Model model){
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        return "addModule";
    }
    // stworzenie end-point dla widoku gdzie pokazujemy wszystkie dane o module

    @GetMapping("/moduleDetails/{id}")
    public String showModuleDetails(@PathVariable("id")Long id, Model model){
        ModuleModel module = moduleService.getModuleById(id);
        model.addAttribute("moduleModel", module);
        return "moduleDetails";
    }

    // zapis modułu w repozytorium modułów
    @PostMapping("/addModule")
    public RedirectView postAddModule(ModuleModel module){
        moduleService.addModule(module);
        return new RedirectView("/modules");
    }

    @PutMapping("/editModule/{id}")
    public String editModule(@PathVariable("id") Long id, Model model){
        ModuleModel module = moduleService.getModuleById(id);
        model.addAttribute("moduleModel", module);
        return "editModule";
    }

    @DeleteMapping("/deleteModule/{id}") //
    public RedirectView deleteModule(@PathVariable("id") Long id){
        moduleService.deleteModule(id);
        return new RedirectView("/modules");
    }


}
