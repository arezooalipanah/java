package com.example.boilerplate_spring.repositories;

import com.example.boilerplate_spring.exceptions.ServiceException;

import java.util.List;

public interface BaseRepository<T> {
    void add(T entity) throws ServiceException;

    void update(T entity) throws ServiceException;

    void removeById(Long id) throws ServiceException;

    T findById(Long id) throws ServiceException;

    List<T> getAll() throws ServiceException;
}
