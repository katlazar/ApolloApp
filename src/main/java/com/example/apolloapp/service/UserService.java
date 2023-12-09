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

    public PasswordEncoder passwordEncoder(){
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
//        if(!userExists(user)){
            userRepository.save(user);
//        } else{
//            throw new RuntimeException("User with the same name already exist in the data base. Change name.");
//        }

    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("Course does not exist. Check input"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    private boolean userExists(UserModel user){
//        UserModel existingUser = UserRepository.findBySurname(user.getSurname());
//        return existingUser != null;
//        // jeżeli nie jest null to kurs już istnieje
//    }

    public UserModel getCurrentlyLoggedUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsernameOrEmail(principal.getUsername(), principal.getUsername());
    }


}
