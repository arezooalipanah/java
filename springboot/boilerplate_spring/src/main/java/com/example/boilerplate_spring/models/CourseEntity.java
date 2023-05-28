package com.example.boilerplate_spring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "THIRD_COURSE")
@Data
public class CourseEntity extends AbstractEntity {
    private String name;
    private String topic;
    private Integer unit;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<StudentEntity> students;
}
