package com.example.boilerplate_spring.converters;

import com.example.boilerplate_spring.models.CourseEntity;
import com.example.boilerplate_spring.models.DTOs.CourseDto;
import org.springframework.stereotype.Service;

@Service
public class CourseConverter implements BaseConverter<CourseDto, CourseEntity> {
    @Override
    public CourseEntity convertDto(CourseDto d) {
        CourseEntity e = new CourseEntity();
        e.setName(d.getName());
        e.setVersion(d.getVersion());
        e.setId(d.getId());
        e.setInsertTimestamp(d.getInsertTimestamp());
        e.setLastUpdateTimestamp(d.getLastUpdateTimestamp());
        e.setUnit(d.getUnit());
        e.setTopic(d.getTopic());
        return e;
    }

    @Override
    public CourseDto convertEntity(CourseEntity e) {
        CourseDto d = new CourseDto();
        d.setName(e.getName());
        d.setVersion(e.getVersion());
        d.setId(e.getId());
        d.setInsertTimestamp(e.getInsertTimestamp());
        d.setLastUpdateTimestamp(e.getLastUpdateTimestamp());
        d.setUnit(e.getUnit());
        d.setTopic(e.getTopic());
        return d;
    }
}
