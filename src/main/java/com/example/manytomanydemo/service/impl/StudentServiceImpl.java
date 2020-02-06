package com.example.manytomanydemo.service.impl;

import com.example.manytomanydemo.database.dao.StudentDao;
import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.dto.StudentDTO;
import com.example.manytomanydemo.service.StudentService;
import com.example.manytomanydemo.service.transformers.EntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentDao studentDao;

    @Override
    public void studentCreate(StudentDTO studentDTO) {

        Student student = convertStudentDtoToStudentEntity(studentDTO);
        Student createdStudent = studentDao.studentCreate(student);
    }

    private Student convertStudentDtoToStudentEntity(StudentDTO studentDTO) {
        return EntityTransformer.toStudentEntity(studentDTO);
    }
}
