package com.example.querydslspringdata.repository.impl;

import com.example.querydslspringdata.entity.QAuthor;
import com.example.querydslspringdata.entity.QBook;
import com.example.querydslspringdata.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    protected final QAuthor author = QAuthor.author;
    protected final QBook book = QBook.book;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.em = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("entity not found with id" + id));
    }
}
