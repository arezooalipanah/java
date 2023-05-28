package com.moneytransfer.core;

import com.moneytransfer.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional(readOnly = true)
public abstract class AbstractController<E, D> {
    @Autowired
    protected AbstractService<? extends JpaRepository<E, Long>, E> service;

    @Autowired
    private BaseConverter<E, D> converter;

    @PostMapping
    @Transactional
    public void add(@Validated @RequestBody D d) throws ServiceException {
        service.add(converter.convertDto(d));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody D d) throws ServiceException {
        service.update(converter.convertDto(d));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteById(@PathVariable("id") Long id) throws ServiceException {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public D findByid(@PathVariable("id") Long id) throws ServiceException {
        return converter.convertEntity(service.findById(id).get());
    }

    @GetMapping()
    public List<D> getAll() throws Exception {
        return converter.convertEntity(service.getAll());
    }

    @PostMapping("/search")
    public List<D> findByExample(@RequestBody D e) throws ServiceException {
        return converter.convertEntity(service.findByExample(converter.convertDto(e)));
    }
}
