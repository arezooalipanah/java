package com.example.boilerplate_spring.services;

import com.example.boilerplate_spring.controllers.AbstractService;
import com.example.boilerplate_spring.models.TeacherEntity;
import com.example.boilerplate_spring.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends AbstractService<TeacherRepository, TeacherEntity> {
}
