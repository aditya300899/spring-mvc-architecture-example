package com.example.manytomanydemo.service;

import com.example.manytomanydemo.dto.SubjectDTO;
import com.example.manytomanydemo.request.AddStudentToSubjectRequest;
import org.springframework.dao.DataIntegrityViolationException;

public interface SubjectService {
    void subjectCreate (SubjectDTO subjectDTO) throws DataIntegrityViolationException;

    SubjectDTO getSubject(String subjectName);

    void addStudentToSubject(AddStudentToSubjectRequest request);

    void deleteSubject(String subjectName);

    void updateSubject(String subjectName, SubjectDTO subjectDto);

    void deleteStudentFromSubject(String subjectName, String studentRollNumber);
}
