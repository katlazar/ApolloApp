package com.example.apolloapp.controller;

import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // dodanie nauczyciela do konkretnego modułu --> button "Dodaj nauczyciela / prowadzącego" przy module
    @GetMapping("/addUser")
    public String addUser(Model model){
        List<UserModel> list = userService.getUserList();
        model.addAttribute("userModel", list);
        return "userList";
    }
    @PostMapping("/addUser")
    public RedirectView postAddUser(UserModel user){
        userService.addUser(user);
        return new RedirectView("/users");
    }

    @PutMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        UserModel user = userService.getUserById(id);
        model.addAttribute("userModel", user);
        return "editUser";
        // todo czy powinniśmy dodać też post mapping dla edit?---> zamiana na @Put
    }

    @DeleteMapping
    public RedirectView deleteUser(@PathVariable("id") Long id, Model model){
        userService.deleteUser(id);
        return new RedirectView("/users");
    }


}
