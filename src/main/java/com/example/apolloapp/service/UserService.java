package com.example.apolloapp.service;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.model.EnrollmentModel;
import com.example.apolloapp.model.RoleModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.repository.CourseRepository;
import com.example.apolloapp.repository.EnrollmentRepository;
import com.example.apolloapp.repository.RoleRepository;
import com.example.apolloapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<UserModel> getUserList() {
        return userRepository.findAll();
    }

    public void addUser(UserModel user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        RoleModel role = roleRepository.findByTypeName("ROLE_USER");
        user.setRole(role);
        user.setType("user");

        UserModel existingUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getUsername());
        if (existingUser == null) {
            userRepository.save(user);
        } else {
            throw new RuntimeException("User with the same name already exist in the data base. Change name.");
        }
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User does not exist. Check input"));
    }

    public UserModel getCurrentlyLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsernameOrEmail(username, username);
    }

    public String addEnrollmentForUser(Long courseId) {
        CourseModel courseModel = courseRepository.findCourseById(courseId);
        courseModel.setEnroll(courseModel.getEnroll()+1);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel userModel = userRepository.findByUsernameOrEmail(username, username);
        RoleModel role = roleRepository.findByTypeName("ROLE_STUDENT"); // po zakupie kursu USER staje się STUDENTEM
        userModel.setRole(role);
        userModel.setType("student");

        EnrollmentModel enrollment = new EnrollmentModel();
        enrollment.setUser(userModel);
        enrollment.setCourse(courseModel);
        enrollment.setCreationDate(LocalDate.now());
        enrollment.setPaymentStatus(true);
        enrollment.setCoursePrice(courseModel.getBasePrice());
        enrollmentRepository.save(enrollment);
        return courseModel.getName();
    }

    public List<UserModel> getTeacherList() {
        return userRepository.findByType("teacher");
    }
}
