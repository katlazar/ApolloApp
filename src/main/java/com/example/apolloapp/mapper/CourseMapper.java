package com.example.apolloapp.mapper;

import com.example.apolloapp.dto.CourseDto;
import com.example.apolloapp.model.CourseModel;

public class CourseMapper {

    // przekazanie danych z obiektu CourseDto do naszego modelu do zapisu
    public static CourseModel toCourseModel(CourseDto courseDto){
        CourseModel courseModel = new CourseModel();
        courseModel.setName(courseDto.getName());
        courseModel.setDescription(courseDto.getDescription());
        courseModel.setBasePrice(courseDto.getBasePrice());
        courseModel.setStartDate(courseDto.getStartDate());
        courseModel.setEndDate(courseDto.getEndDate());
        courseModel.setCapacity(courseDto.getCapacity());
        return courseModel;
    }

    // przekazanie danych z naszego modelu do obiektu Dto
    public static CourseDto toCourseDto(CourseModel courseModel){
        CourseDto courseDto = new CourseDto();
        courseDto.setName(courseModel.getName());
        courseDto.setDescription(courseModel.getDescription());
        courseDto.setBasePrice(courseModel.getBasePrice());
        courseDto.setStartDate(courseModel.getStartDate());
        courseDto.setEndDate(courseModel.getEndDate());
        courseDto.setTotalHours(courseModel.getTotalHours());
        courseDto.setCapacity(courseModel.getCapacity());
        return courseDto;
    }


}
