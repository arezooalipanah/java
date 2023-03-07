package com.example.boilerplate_spring.converters;

import com.example.boilerplate_spring.models.DTOs.TeacherDto;
import com.example.boilerplate_spring.models.TeacherEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherConverter implements BaseConverter<TeacherDto, TeacherEntity> {
    @Override
    public TeacherEntity convertDto(TeacherDto d) {
        TeacherEntity e =  new TeacherEntity();
        e.setName(d.getName());
        e.setFamily(d.getFamily());
        e.setEmployedDate(d.getEmployedDate());
        e.setGender(d.getGender());
        e.setEducationLevel(d.getEducationLevel());
        e.setNationalCode(d.getNationalCode());
        e.setVersion(d.getVersion());
        e.setId(d.getId());
        e.setInsertTimestamp(d.getInsertTimestamp());
        e.setLastUpdateTimestamp(d.getLastUpdateTimestamp());
        return e;
    }

    @Override
    public TeacherDto convertEntity(TeacherEntity e) {
        TeacherDto d = new TeacherDto();
        d.setName(e.getName());
        d.setFamily(e.getFamily());
        d.setEmployedDate(e.getEmployedDate());
        d.setGender(e.getGender());
        d.setEducationLevel(e.getEducationLevel());
        d.setNationalCode(e.getNationalCode());
        d.setVersion(e.getVersion());
        d.setId(e.getId());
        d.setInsertTimestamp(e.getInsertTimestamp());
        d.setLastUpdateTimestamp(e.getLastUpdateTimestamp());
        return d;
    }
}
