package com.example.boilerplate_spring.services;

import com.example.boilerplate_spring.controllers.AbstractService;
import com.example.boilerplate_spring.models.StudentEntity;
import com.example.boilerplate_spring.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends AbstractService<StudentRepository, StudentEntity> {

}
