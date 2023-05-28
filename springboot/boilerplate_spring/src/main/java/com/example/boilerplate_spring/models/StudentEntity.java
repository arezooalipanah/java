package com.example.boilerplate_spring.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "THIRD_STUDENT")
@Data
public class StudentEntity extends AbstractEntity{
    @Column(name="FIRST_NAME")
    private String name;
    private String family;
    private Integer passedCourse;
    @Column(unique = true)
    private String nationalCode;
    @Column(unique = true)
    private String studentId;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CourseEntity> courses;
}
