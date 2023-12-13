package com.example.apolloapp.service;

import com.example.apolloapp.dto.ModuleDto;
import com.example.apolloapp.mapper.ModuleMapper;
import com.example.apolloapp.model.ModuleModel;
import com.example.apolloapp.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    public List<ModuleModel> getModuleList() {
        return moduleRepository.findAll();
    }

    public void addModule(ModuleDto moduleDto) {
        if(!moduleExists(moduleDto)){
            ModuleModel moduleModel = moduleMapper.toModuleModel(moduleDto);
            moduleRepository.save(moduleModel);
        } else{
            throw new RuntimeException("Module with the same name already exist in the data base. Change name.");
        }
    }

    public ModuleModel getModuleById(Long id) {
        return moduleRepository.findById(id).orElseThrow(()->new RuntimeException("Module does not exist. Check input"));
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    private boolean moduleExists(ModuleDto moduleDto){
        ModuleModel existingModule = moduleRepository.findBySubject(moduleDto.getSubject());
        return existingModule != null;
    }

    public void saveEditedModule(ModuleDto moduleDto) {
        ModuleModel moduleModel = moduleMapper.toModuleModel(moduleDto);
        moduleRepository.save(moduleModel);
    }
}
