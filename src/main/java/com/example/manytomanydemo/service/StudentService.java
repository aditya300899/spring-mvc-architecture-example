package com.example.manytomanydemo.service;

import com.example.manytomanydemo.database.entity.Subject;
import com.example.manytomanydemo.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    void studentCreate(StudentDTO studentDTO);

    StudentDTO getStudent(String studentRollNumber);

    void deleteStudent(String studentRollNumber);

    void updateStudent(String studentRollNumber, StudentDTO student);

    List<Subject> getSubjectsOfStudent(String studentRollNumber);
}
