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

    @Override
    public Student getStudent(String studentRollNumber) {
        return studentRepository.findByStudentRollNumber(studentRollNumber);
    }

    @Override
    public void deleteStudent(String studentRollNumber) {
        Student student = studentRepository.findByStudentRollNumber(studentRollNumber);
//      student.setSubjects(new ArrayList<>());
        studentRepository.delete(student);
        return;
    }

    @Override
    public void updateStudent(String studentRollNumber, Student student) {
        Student student1 = studentRepository.findByStudentRollNumber(studentRollNumber);
        student1.setStudentPhoneNumber(student.getStudentPhoneNumber());
        student1.setStudentAddress(student.getStudentAddress());
        studentRepository.save(student1);
        return;
    }
}
