package com.example.apolloapp.service;

import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<UserModel> getUserList() {
        return userRepository.findAll();
    }

    public void addUser(UserModel user) {
        userRepository.save(user);
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserModel getCurrentlyLoggedUser() {
        UserDetails principal = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsernameOrEmail(principal.getUsername(), principal.getUsername());
    }
}
