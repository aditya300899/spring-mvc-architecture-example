package com.example.manytomanydemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
public class StudentDTO {

    @JsonProperty("student_name")
    @NotEmpty(message = "Student name can't be empty.")
    private String name;

    @JsonProperty("student_father_name")
    private String studentFatherName;

    @JsonProperty("student_mother_name")
    private String studentMotherName;

    @NotEmpty
    @JsonProperty("student_dob")
    private String studentDob;

    @NotNull(message = "Phone number can't be empty.")
    @JsonProperty("student_phone_number")
    private Long studentPhoneNumber;

    @JsonProperty("student_address")
    private String studentAddress;

    @NotNull(message = "Roll number can't be empty.")
    @JsonProperty("student_roll_number")
    private String studentRollNumber;
}
