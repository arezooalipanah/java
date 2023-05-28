package com.example.boilerplate_spring.models;


import com.example.boilerplate_spring.models.enums.EducationLevel;
import com.example.boilerplate_spring.models.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "TEACHER")
@EntityListeners(AuditingEntityListener.class)
@Data
public class TeacherEntity extends AbstractEntity {
    private String name;
    private String family;
    @Column(unique = true)
    private String nationalCode;
    @Temporal(TemporalType.TIMESTAMP)
    private Date employedDate;
    private String level;
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
