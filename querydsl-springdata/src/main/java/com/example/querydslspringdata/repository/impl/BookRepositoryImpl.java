package com.example.querydslspringdata.repository.impl;

import com.example.querydslspringdata.entity.Book;
import com.example.querydslspringdata.repository.BookRepository;
import jakarta.persistence.EntityManager;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {
    public BookRepositoryImpl(EntityManager entityManager) {
        super(Book.class, entityManager);
    }
}
