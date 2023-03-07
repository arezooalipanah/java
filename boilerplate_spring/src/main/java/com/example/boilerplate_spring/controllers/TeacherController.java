package com.example.boilerplate_spring.controllers;

import com.example.boilerplate_spring.models.DTOs.TeacherDto;
import com.example.boilerplate_spring.models.TeacherEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends AbstractController<TeacherEntity, TeacherDto>{
}
