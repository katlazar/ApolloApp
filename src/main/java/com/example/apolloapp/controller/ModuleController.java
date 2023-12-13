package com.example.apolloapp.controller;

import com.example.apolloapp.dto.ModuleDto;
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
public class ModuleController {

    private final ModuleService moduleService;
    private final UserService userService;

    @GetMapping("/addModule")
    public String addModule(Model model){
        List<UserModel> list = userService.getTeacherList();
        model.addAttribute("userModel", list);
        return "add-new-module";
    }

    @GetMapping("/moduleDetails/{id}")
    public String showModuleDetails(@PathVariable("id")Long id, Model model){
        ModuleModel module = moduleService.getModuleById(id);
        model.addAttribute("moduleModel", module);
        List<UserModel> list = userService.getTeacherList();
        model.addAttribute("userModel", list);
        return "edit-module";
    }

    @PostMapping("/addModule")
    public RedirectView postAddModule(ModuleDto moduleDto){
        moduleService.addModule(moduleDto);
        return new RedirectView("/modules");
    }

    @PostMapping("/editModule")
    public RedirectView editModule(ModuleDto moduleDto){
        moduleService.saveEditedModule(moduleDto);
        return new RedirectView("/modules");
    }

    @PostMapping("/deleteModule") //
    public RedirectView deleteModule(@ModelAttribute("id") Long id) {
        moduleService.deleteModule(id);
        return new RedirectView("/modules");
    }

}
