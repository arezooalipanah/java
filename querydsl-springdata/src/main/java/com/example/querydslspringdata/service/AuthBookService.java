package com.example.querydslspringdata.service;

import com.example.querydslspringdata.dto.AuthorStatistic;
import com.example.querydslspringdata.entity.Author;
import com.example.querydslspringdata.repository.AuthorRepository;
import com.example.querydslspringdata.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthBookService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return authorRepository.findAuthorByEmail(email);
    }

    public List<AuthorStatistic> getAuthorStatistic() {
        return authorRepository.getAuthorStatistic();
    }

    public List<Author> getAuthorsWithFetchJoin() {
        return authorRepository.getAuthors();
    }
}
