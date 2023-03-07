package com.example.boilerplate_spring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "THIRD_COURSE")
public class CourseEntity extends AbstractEntity{
    private String name;
    private String topic;
    private Integer unit;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<StudentEntity> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
