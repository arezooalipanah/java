package com.example.querydslspringdata.repository;

import com.example.querydslspringdata.dto.AuthorStatistic;
import com.example.querydslspringdata.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository<Author, Integer> {
    public Optional<Author> findAuthorByEmail(String email);

    public List<AuthorStatistic> getAuthorStatistic();

    public List<Author> getAuthors();
}
