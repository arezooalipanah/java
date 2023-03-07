package com.example.boilerplate_spring.repositories;

import com.example.boilerplate_spring.models.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
