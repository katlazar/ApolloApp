package com.example.apolloapp.service;

import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    public UserModel getUser(){
//        return userRepository.
//    }


}
