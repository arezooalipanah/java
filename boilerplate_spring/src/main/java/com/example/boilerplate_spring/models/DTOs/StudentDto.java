package com.example.boilerplate_spring.models.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto extends AbstractDto {
    private String name;
    private String family;
    private Integer passedCourse;
    private String nationalCode;
    private String studentId;
    private List<CourseDto> courses;
}
