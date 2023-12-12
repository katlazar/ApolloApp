package com.example.apolloapp.repository;

import com.example.apolloapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


    UserModel findByUsernameOrEmail(String username, String email);

    List<UserModel> findByType(String teacher);

    List<UserModel> findByDeleted(boolean b);

}
