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
        List<UserModel> list = userService.getUserList();
        model.addAttribute("userModel", list);
        return "userList";
    }

    // admin pobiera listę wszytskich kursów ---> w wierszu tabeli z nazwą kursu na końcu button "Edytuj"
    @GetMapping("/a-courses")
    public String getCourseList(Model model){
        List<CourseModel> list = courseService.getCourseList();
        model.addAttribute("courseModel", list);
        return "admin-course-list";
    }

    // admin pobiera listę wszytskich kursów ---> w wierszu tabeli z nazwą modułu na końcu button "Edytuj"
    @GetMapping("/modules")
    public String getModuleList(Model model){
        List<ModuleModel> list = moduleService.getModuleList();
        model.addAttribute("moduleList", list);
        return "moduleList";
    }

}
