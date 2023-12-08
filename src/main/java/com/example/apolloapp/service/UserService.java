package com.example.apolloapp.service;

import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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


}
