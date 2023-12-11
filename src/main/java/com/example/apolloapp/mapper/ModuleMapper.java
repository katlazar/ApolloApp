package com.example.apolloapp.mapper;

import com.example.apolloapp.dto.ModuleDto;
import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.model.ModuleModel;

public class ModuleMapper {

    public static ModuleModel toModuleModel(ModuleDto moduleDto){
        ModuleModel moduleModel = new ModuleModel();
        moduleModel.setSubject(moduleDto.getSubject());
        moduleModel.setUserId(moduleDto.getUserId());
        moduleModel.setStartDate(moduleDto.getStartDate());
        moduleModel.setEndDate(moduleDto.getEndDate());
        moduleModel.setTotalHours(moduleDto.getTotalHours());
        return moduleModel;
    }

    public static ModuleDto toModuleDto(ModuleModel moduleModel){
        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setSubject(moduleModel.getSubject());
        moduleDto.setUserId(moduleModel.getUserId());
        moduleDto.setStartDate(moduleModel.getStartDate());
        moduleDto.setEndDate(moduleModel.getEndDate());
        moduleDto.setTotalHours(moduleModel.getTotalHours());
        return moduleDto;
    }
}
