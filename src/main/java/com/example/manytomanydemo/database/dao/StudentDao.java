package com.example.manytomanydemo.database.dao;

import com.example.manytomanydemo.database.entity.Student;

public interface StudentDao {

    Student studentCreate(Student student);

    Student getStudent(String studentRollNumber);

    void deleteStudent(String studentRollNumber);

    void updateStudent(String studentRollNumber, Student student);
}
