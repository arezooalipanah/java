package com.example.querydslspringdata.repository.impl;

import com.example.querydslspringdata.dto.AuthorStatistic;
import com.example.querydslspringdata.entity.Author;
import com.example.querydslspringdata.repository.AuthorRepository;
import com.querydsl.core.types.Projections;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class AuthRepositoryImpl extends BaseRepositoryImpl<Author, Integer> implements AuthorRepository {
    public AuthRepositoryImpl(EntityManager entityManager) {
        super(Author.class, entityManager);
    }

    @Override
    public Optional<Author> findAuthorByEmail(String email) {
        return Optional.ofNullable(jpaQueryFactory
                .select(author)
                .from(author)
                .where(author.email.equalsIgnoreCase(email))
                .fetchFirst());
    }

    @Override
    public List<AuthorStatistic> getAuthorStatistic() {
        return jpaQueryFactory.from(author)
//                .innerJoin(author.books, book)
                .groupBy(author.name)
                .select(Projections.constructor(AuthorStatistic.class, author.name, book.count())).fetch();
    }

    @Override
    public List<Author> getAuthors() {
        return jpaQueryFactory
                .select(author)
                .distinct()
                .from(author)
//                .innerJoin(author.books, book)
                .fetchJoin().fetch();
    }
}
