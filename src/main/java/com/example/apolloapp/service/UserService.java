package com.example.apolloapp.service;

import com.example.apolloapp.model.RoleModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.repository.RoleRepository;
import com.example.apolloapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<UserModel> getUserList() {
        return userRepository.findAll();
    }

    public void addUser(UserModel user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        Set<RoleModel> roles = new HashSet<>();
        roles.add(roleRepository.findById(2L).orElse(null));
        user.setRoles(roles);
        user.setType("user");

        UserModel existingUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getUsername());
        if (existingUser == null) {
            userRepository.save(user);
        } else {
            throw new RuntimeException("User with the same name already exist in the data base. Change name.");
        }
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Course does not exist. Check input"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserModel getCurrentlyLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsernameOrEmail(username, username);
    }


}
