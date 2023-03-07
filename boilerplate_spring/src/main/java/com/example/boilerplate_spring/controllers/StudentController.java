package com.example.boilerplate_spring.controllers;

import com.example.boilerplate_spring.models.DTOs.StudentDto;
import com.example.boilerplate_spring.models.StudentEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<StudentEntity, StudentDto> {
}

class Response<T> {
    private String errorMessage;
    private T result;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
