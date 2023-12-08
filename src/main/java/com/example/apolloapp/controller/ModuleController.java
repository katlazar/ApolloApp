package com.example.apolloapp.controller;

import com.example.apolloapp.model.ModuleModel;
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

    //pobranie listy modułów z bazy danych
    @GetMapping("/modules")
    public String getModuleList(Model model){
        List<ModuleModel> list = moduleService.getModuleList();
        model.addAttribute("moduleModel", list);
        return "moduleList";
    }

    // dodanie modułu do konkretnego kursu --> button "Dodaj moduł" przy kursie
    @GetMapping("/addModule")
    public String addModule(Model model){
        List<ModuleModel> list = moduleService.getModuleList();
        model.addAttribute("moduleModel", list);
        return "addModule";
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
        // todo czy powinniśmy dodać też post mapping dla edit? --> zamiana na @Put
    }

    @DeleteMapping("/deteleModule/{id}") //
    public RedirectView deleteModule(@PathVariable("id") Long id, Model model){
        moduleService.deleteModule(id);
        return new RedirectView("/courses");
    }

}
