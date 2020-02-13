package com.example.manytomanydemo.service;

import com.example.manytomanydemo.dto.StudentDTO;

public interface StudentService {
    void studentCreate(StudentDTO studentDTO);

    StudentDTO getStudent(String studentRollNumber);

    void deleteStudent(String studentRollNumber);

    void updateStudent(String studentRollNumber, StudentDTO student);
}
