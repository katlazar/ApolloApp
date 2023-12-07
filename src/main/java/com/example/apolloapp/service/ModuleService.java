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
        // jeżeli istnieje obiekt o danym id to edit nadpisze zminaay
        // dodać lepiej metode do edit
    }

    public ModuleModel getModuleById(Long id) {
        return moduleRepository.findById(id).orElseThrow(()->new RuntimeException("Nie ma obiektu")); // do stworzenia własny  exeption
        // TODO try-catch na null? + return message if not exist
    }


    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
