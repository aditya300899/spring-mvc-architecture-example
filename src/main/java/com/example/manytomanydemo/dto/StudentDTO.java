package com.example.manytomanydemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class StudentDTO {

    @JsonProperty("student_name")
    @NotEmpty(message = "Student name can't be empty.")
    private String name;
}
