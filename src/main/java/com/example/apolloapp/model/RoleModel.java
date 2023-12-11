package com.example.apolloapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="type_name")
    private String typeName;

    @OneToMany(mappedBy = "role")
    private Set<UserModel> users;
}
