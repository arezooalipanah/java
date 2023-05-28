package com.example.boilerplate_spring.services;

import com.example.boilerplate_spring.controllers.AbstractService;
import com.example.boilerplate_spring.models.CourseEntity;
import com.example.boilerplate_spring.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends AbstractService<CourseRepository, CourseEntity> {
}
