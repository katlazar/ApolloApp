package com.example.apolloapp.repository;

import com.example.apolloapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


    UserModel findByUsernameOrEmail(String username, String email);  // do rozważenie czy wyszukiwanie po email jest nam potrzebne?

    List<UserModel> findByType(String teacher);
    // ---> w UserDetail jest problem z implementacją metody loadUserByUsername(String name)

   // UserModel findByName(String name); -->wymusza wykonanie metody static

}
