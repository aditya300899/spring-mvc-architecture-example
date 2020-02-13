package com.example.manytomanydemo.service.transformers;

import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.dto.StudentDTO;
import com.example.manytomanydemo.dto.SubjectDTO;
import com.example.manytomanydemo.database.entity.Subject;

public class EntityTransformer {
    public static Subject toSubjectEntity(SubjectDTO subjectDTO){
        Subject subject = new Subject();
        subject.setSubjectName(subjectDTO.getSubjectName());
        return subject;
    }

    public static Student toStudentEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentName(studentDTO.getName());
        student.setStudentFatherName(studentDTO.getStudentFatherName());
        student.setStudentMotherName(studentDTO.getStudentMotherName());
        student.setStudentDob(studentDTO.getStudentDob());
        student.setStudentAddress(studentDTO.getStudentAddress());
        student.setStudentPhoneNumber(studentDTO.getStudentPhoneNumber());
        student.setStudentRollNumber(studentDTO.getStudentRollNumber());
        return student;
    }
}
