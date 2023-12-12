package com.example.apolloapp.controller;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.model.ModuleModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.service.CourseService;
import com.example.apolloapp.service.ModuleService;
import com.example.apolloapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final CourseService courseService;
    private final ModuleService moduleService;

    // otworzenie panelu administratora
    @GetMapping("/admin")
    public String getAdmin(Model model) {
        model.addAttribute("userObject", userService.getCurrentlyLoggedUser());
        return "adminPanel";
    }

    // admin pobiera listę wszytskich users (ADMIN / STUDENT / TEACHER) ---> w wierszu tabeli z nazwiskami users na końcu button "Edytuj"
    @GetMapping("/users")
    public String getUserList(Model model){
        List<UserModel> list = userService.getActiveUserList();
        model.addAttribute("userModel", list);
        model.addAttribute("userObject", userService.getCurrentlyLoggedUser());
        return "admin-user-list";
    }

    @PostMapping("/users")
    public String editeUser(@ModelAttribute("userId") Long userId, @ModelAttribute("type") String userType) {
        userService.saveEditedUser(userId, userType);
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("userId") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

    @GetMapping("/teachers")
    public String getTeacherList(Model model){
        List<UserModel> list = userService.getTeacherList();
        model.addAttribute("userModel", list);
        model.addAttribute("userObject", userService.getCurrentlyLoggedUser());
        return "admin-teacher-list";
    }

    // admin pobiera listę wszytskich kursów ---> w wierszu tabeli z nazwą kursu na końcu button "Edytuj"
    @GetMapping("/a-courses")
    public String getCourseList(Model model){
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        model.addAttribute("userObject", userService.getCurrentlyLoggedUser());
        return "admin-course-list";
    }

    // admin pobiera listę wszytskich modułów
    @GetMapping("/modules")
    public String getModuleList(Model model){
        List<ModuleModel> list = moduleService.getModuleList();
        model.addAttribute("moduleModel", list);
        model.addAttribute("userObject", userService.getCurrentlyLoggedUser());
        return "admin-module-list";
    }

}
