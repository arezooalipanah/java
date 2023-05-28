package com.example.boilerplate_spring.models.DTOs;

import com.example.boilerplate_spring.models.AbstractEntity;
import com.example.boilerplate_spring.models.enums.EducationLevel;
import com.example.boilerplate_spring.models.enums.Gender;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherDto extends AbstractEntity {
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$")
    private String name;
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,40}$")
    private String family;
    @Pattern(regexp = "^\\d{10}$", message = "کدملی اشتباه است")
    private String nationalCode;
    @Past
    private Date employedDate;
    @Pattern(regexp = "^a|b|c$")
    private String level;
    private EducationLevel educationLevel;
    private Gender gender;
}
