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
        if(!moduleExists(module)){
            moduleRepository.save(module);
        } else{
            throw new RuntimeException("Module with the same name already exist in the data base. Change name.");
        }
        // jeżeli istnieje obiekt o danym id to edit nadpisze zminaay
        // dodać lepiej metode do edit
    }

    public ModuleModel getModuleById(Long id) {
        return moduleRepository.findById(id).orElseThrow(()->new RuntimeException("Module does not exist. Check input"));
        // do stworzenia własny  exeption
    }


    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    private boolean moduleExists(ModuleModel module){
        ModuleModel existingModule = moduleRepository.findBySubject(module.getSubject());
        return existingModule != null;
        // jeżeli nie jest null to moduł już istnieje
    }


}
