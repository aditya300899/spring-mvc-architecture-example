package com.example.manytomanydemo.service.impl;

import com.example.manytomanydemo.database.dao.StudentDao;
import com.example.manytomanydemo.database.dao.SubjectDao;
import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.database.entity.Subject;
import com.example.manytomanydemo.dto.StudentDTO;
import com.example.manytomanydemo.service.StudentService;
import com.example.manytomanydemo.service.transformers.DtoTransformer;
import com.example.manytomanydemo.service.transformers.EntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentDao studentDao;

    @Autowired
    SubjectDao subjectDao;

    @Override
    public void studentCreate(StudentDTO studentDTO) {

        Student student = convertStudentDtoToStudentEntity(studentDTO);
        studentDao.studentCreate(student);
    }

    @Override
    public StudentDTO getStudent(String studentRollNumber) {
        Student student = studentDao.getStudent(studentRollNumber);
        return convertStudentEntityToStudentDto(student);
    }

    @Override
    public void deleteStudent(String studentRollNumber) {
        studentDao.deleteStudent(studentRollNumber);
        return;
    }

    @Override
    public void updateStudent(String studentRollNumber, StudentDTO studentDto) {
        Student student = convertStudentDtoToStudentEntity(studentDto);
        studentDao.updateStudent(studentRollNumber, student);
        return;
    }

    @Override
    public List<Subject> getSubjectsOfStudent(String studentRollNumber) {
        Student student = studentDao.getStudent(studentRollNumber);
        return student.getSubjects();
    }

    private StudentDTO convertStudentEntityToStudentDto(Student student) {
      return  DtoTransformer.toStudentDto(student);
    }

    private Student convertStudentDtoToStudentEntity(StudentDTO studentDTO) {
        return EntityTransformer.toStudentEntity(studentDTO);
    }
}
