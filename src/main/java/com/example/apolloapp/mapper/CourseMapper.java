package com.example.apolloapp.mapper;

import com.example.apolloapp.dto.CourseDto;
import com.example.apolloapp.model.CourseModel;
import com.example.apolloapp.model.ModuleModel;
import com.example.apolloapp.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseMapper {

    private final ModuleRepository moduleRepository;

    public CourseModel toCourseModel(CourseDto courseDto){
        CourseModel courseModel = new CourseModel();

        courseModel.setName(courseDto.getName());
        courseModel.setDescription(courseDto.getDescription());
        courseModel.setBasePrice(courseDto.getBasePrice());
        courseModel.setType(courseDto.getType());
        courseModel.setStartDate(courseDto.getStartDate());
        courseModel.setEndDate(courseDto.getEndDate());
        courseModel.setCapacity(courseDto.getCapacity());

        List<ModuleModel> moduleList = moduleRepository.findAllById(courseDto.getModuleId());
        courseModel.setModules(moduleList);

        int totalHoursSum = moduleList.stream()
                .mapToInt(ModuleModel::getTotalHours)
                .sum();
        courseModel.setTotalHours(totalHoursSum);

        return courseModel;
    }
}
