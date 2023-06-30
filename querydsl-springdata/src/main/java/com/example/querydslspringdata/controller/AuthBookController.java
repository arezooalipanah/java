package com.example.querydslspringdata.controller;

import com.example.querydslspringdata.entity.Author;
import com.example.querydslspringdata.service.AuthBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AuthBookController {
    @Autowired
    private AuthBookService authBookService;


    @GetMapping("")
    public List<Author> getAllAuthors() {
        return authBookService.getAuthors();
    }
}
