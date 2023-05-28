package com.example.boilerplate_spring.controllers;

import com.example.boilerplate_spring.models.CourseEntity;
import com.example.boilerplate_spring.models.DTOs.CourseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController extends AbstractController<CourseEntity, CourseDto> {
}
