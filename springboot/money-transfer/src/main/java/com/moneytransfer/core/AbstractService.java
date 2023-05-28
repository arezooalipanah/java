package com.moneytransfer.core;

import com.moneytransfer.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<R extends BaseRepository<E, Long>, E> {
    @Autowired
    protected R repository;

    public void add(E e) throws ServiceException {
        repository.save(e);
    }

    public void update(E e) throws ServiceException {
        repository.save(e);
    }

    public void deleteById(Long id) throws ServiceException {
        repository.deleteById(id);
    }

    public Optional<E> findById(Long id) throws ServiceException {
        return repository.findById(id);
    }

    public List<E> getAll() throws ServiceException {
        return repository.findAll();
    }

    public List<E> findByExample(E e) throws ServiceException {
        return repository.findAll(Example.of(e));
    }
}
