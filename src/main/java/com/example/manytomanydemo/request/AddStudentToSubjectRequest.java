package com.example.manytomanydemo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddStudentToSubjectRequest {

    @JsonProperty("subject_name")
    String subjectName;

    @JsonProperty("student_roll_number")
    String studentRollNumber;
}
