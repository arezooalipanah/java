package com.example.boilerplate_spring.models.DTOs;

import lombok.Data;

@Data
public class CourseDto extends AbstractDto {
    private String name;
    private String topic;
    private Integer unit;
}
