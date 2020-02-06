package com.example.manytomanydemo.database.dao.Impl;

import com.example.manytomanydemo.database.dao.StudentDao;
import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDaoImpl implements StudentDao {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student studentCreate(Student student) {
        return studentRepository.save(student);
    }
}
