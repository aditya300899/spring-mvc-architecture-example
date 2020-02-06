package com.example.manytomanydemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SubjectDTO {

    @JsonProperty("subject_name")
    @NotEmpty(message = "Subject name can not be null/empty")
    private String subjectName;

}

