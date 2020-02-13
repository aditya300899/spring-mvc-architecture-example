package com.example.manytomanydemo.service.transformers;

import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.database.entity.Subject;
import com.example.manytomanydemo.dto.StudentDTO;
import com.example.manytomanydemo.dto.SubjectDTO;

public class DtoTransformer {

    public static SubjectDTO toSubjectDto(Subject subject) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectName(subject.getSubjectName());
        return subjectDTO;
    }

    public static StudentDTO toStudentDto(Student student) {
        StudentDTO studentDTO = new StudentDTO() ;
        studentDTO.setName(student.getStudentName());
        studentDTO.setStudentAddress(student.getStudentAddress());
        studentDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
        studentDTO.setStudentDob(student.getStudentDob());
        studentDTO.setStudentFatherName(student.getStudentFatherName());
        studentDTO.setStudentMotherName(student.getStudentMotherName());
        studentDTO.setStudentRollNumber(student.getStudentRollNumber());
        return studentDTO;
    }
}
