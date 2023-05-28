package com.example.boilerplate_spring.repositories;

import com.example.boilerplate_spring.models.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
