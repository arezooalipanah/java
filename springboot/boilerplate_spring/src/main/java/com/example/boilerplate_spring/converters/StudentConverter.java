package com.example.boilerplate_spring.converters;

import com.example.boilerplate_spring.models.DTOs.StudentDto;
import com.example.boilerplate_spring.models.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentConverter implements BaseConverter<StudentDto, StudentEntity> {
    @Autowired
    private CourseConverter courseConverter;
    @Override
    public StudentEntity convertDto(StudentDto d) {
        StudentEntity e = new StudentEntity();
        e.setName(d.getName());
        e.setFamily(d.getFamily());
        e.setStudentId(d.getStudentId());
        e.setNationalCode(d.getNationalCode());
        e.setPassedCourse(d.getPassedCourse());
        e.setVersion(d.getVersion());
        e.setId(d.getId());
        e.setInsertTimestamp(d.getInsertTimestamp());
        e.setLastUpdateTimestamp(d.getLastUpdateTimestamp());
        e.setCourses(courseConverter.convertDto(d.getCourses()));
        return e;
    }

    @Override
    public StudentDto convertEntity(StudentEntity e) {
        StudentDto d = new StudentDto();
        d.setName(e.getName());
        d.setFamily(e.getFamily());
        d.setStudentId(e.getStudentId());
        d.setNationalCode(e.getNationalCode());
        d.setPassedCourse(e.getPassedCourse());
        d.setVersion(e.getVersion());
        d.setId(e.getId());
        d.setInsertTimestamp(e.getInsertTimestamp());
        d.setLastUpdateTimestamp(e.getLastUpdateTimestamp());
        d.setCourses(courseConverter.convertEntity(e.getCourses()));
        return d;
    }
}
