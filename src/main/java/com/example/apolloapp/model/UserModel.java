package com.example.apolloapp.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<EnrollmentModel> enrollments;

    @OneToMany(mappedBy = "teacher")
    private List<ModuleModel> modules;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleModel role;

    @Column(name="deleted")
    private boolean deleted;
}
