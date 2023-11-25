package com.example.apolloapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;

}
