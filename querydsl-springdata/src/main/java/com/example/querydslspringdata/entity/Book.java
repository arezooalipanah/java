package com.example.querydslspringdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    private int bookId;
    private String name;
    private String isbn;

    @ManyToOne
    private Author author;
}
