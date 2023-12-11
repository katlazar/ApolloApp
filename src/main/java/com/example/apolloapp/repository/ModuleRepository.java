package com.example.apolloapp.repository;

import com.example.apolloapp.dto.ModuleDto;
import com.example.apolloapp.model.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleModel, Long> {
    ModuleModel findBySubject(String subject);
}
