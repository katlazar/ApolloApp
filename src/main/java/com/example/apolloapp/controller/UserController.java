package com.example.apolloapp.controller;

import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // do dodawania ogólnie users (ADMIN / STUDENT / TEACHER)
//    @GetMapping("/addUser")
//    public String addUser(Model model){
//        List<UserModel> list = userService.getUserList();
//        model.addAttribute("userModel", list);
//        return "userList";
//    }
//    // do zapisywania ogólnie users (ADMIN / STUDENT / TEACHER)
//    @PostMapping("/addUser")
//    public RedirectView postAddUser(UserModel user){
//        userService.addUser(user);
//        return new RedirectView("/users");
//    }

    // do edycji wszystkich users (ADMIN / STUDENT / TEACHER)
    @PutMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        UserModel user = userService.getUserById(id);
        model.addAttribute("userModel", user);
        return "editUser";
    }

    // do USUWANIA wszystkich users (ADMIN / STUDENT / TEACHER)
    @DeleteMapping
    public RedirectView deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new RedirectView("/users");
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
}
