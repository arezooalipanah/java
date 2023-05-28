package com.example.boilerplate_spring.repositories;

import com.example.boilerplate_spring.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
