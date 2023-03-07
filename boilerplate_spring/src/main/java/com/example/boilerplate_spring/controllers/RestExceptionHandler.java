package com.example.boilerplate_spring.controllers;

import com.example.boilerplate_spring.exceptions.ServiceException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@ControllerAdvice
public class RestExceptionHandler {
    private Properties properties = new Properties();

    @PostConstruct
    public void init() {
        try {
            properties.load(new FileReader("/home/arezoo/code/@JAVA/java_learning/@springBoot/first-project/src/main/resources/exceptions_fa_IR.properties", StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionResponse> handleException(ServiceException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setHasError(true);
        exception.printStackTrace();
        String prop = properties.getProperty(exception.getErrorCode());
        if (prop == null) {
            properties.getProperty("default");
        }
        response.setMessage(prop);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setHasError(true);
        exception.printStackTrace();
        FieldError field = exception.getBindingResult().getFieldError();
        String message = "error in field : " + field.getField() + " " + field.getDefaultMessage();
        response.setMessage(message);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleException(RuntimeException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setHasError(true);
        response.setMessage(properties.getProperty("unknown"));
        exception.printStackTrace();
        return ResponseEntity.badRequest().body(response);
    }
}

class ExceptionResponse {
    private Boolean hasError;

    private String message;

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}