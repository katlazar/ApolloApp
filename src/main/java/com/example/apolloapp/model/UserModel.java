package com.example.apolloapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

@Entity
@Data
@Table(name= "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="type")
    private String type;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private EnrollmentModel enrollment;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="role_user")
    private Set<RoleModel> roles;

}
