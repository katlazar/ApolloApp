package com.example.apolloapp.service;

import com.example.apolloapp.model.ModuleModel;
import com.example.apolloapp.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;


    public List<ModuleModel> getModuleList() {
        return moduleRepository.findAll();
    }


    public void addModule(ModuleModel module) {
        moduleRepository.save(module);
    }

    public ModuleModel getModuleById(Long id) {
        return moduleRepository.findById(id).orElse(null);
        // TODO try-catch na null? + return message if not exist
    }


    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
