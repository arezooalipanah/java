package com.example.boilerplate_spring.controllers;

import com.example.boilerplate_spring.converters.BaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional(readOnly = true)
public abstract class AbstractController<E, D> {
    @Autowired
    private AbstractService<? extends JpaRepository<E, Long>, E> service;

    @Autowired
    private BaseConverter<D, E> converter;

    @PostMapping()
    @Transactional
    public void add(@Validated @RequestBody D e) throws Exception {
        service.add(converter.convertDto(e));
    }

    @PutMapping()
    @Transactional
    public void update(@RequestBody D e) throws Exception {
        service.update(converter.convertDto(e));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public D findById(@PathVariable("id") Long id) throws Exception {
        return converter.convertEntity(service.findById(id).get());
    }

    @GetMapping()
    public List<D> getAll() throws Exception {
        return converter.convertEntity(service.getAll());
    }

    @PostMapping("/search")
    public List<D> findByExample(@RequestBody D e) throws Exception {
        return converter.convertEntity(service.findByExample(converter.convertDto(e)));

    }
}
