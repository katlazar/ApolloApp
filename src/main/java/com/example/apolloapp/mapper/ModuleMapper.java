package com.example.apolloapp.mapper;

import com.example.apolloapp.dto.ModuleDto;
import com.example.apolloapp.model.ModuleModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleMapper {

    private final UserService userService;

    public ModuleModel toModuleModel(ModuleDto moduleDto){
        ModuleModel moduleModel = new ModuleModel();
        moduleModel.setSubject(moduleDto.getSubject());

        UserModel teacher = userService.getUserById(moduleDto.getUserId());
        moduleModel.setTeacher(teacher);

        moduleModel.setStartDate(moduleDto.getStartDate());
        moduleModel.setEndDate(moduleDto.getEndDate());
        moduleModel.setTotalHours(moduleDto.getTotalHours());
        moduleModel.setId(moduleDto.getId());
        return moduleModel;
    }
}
