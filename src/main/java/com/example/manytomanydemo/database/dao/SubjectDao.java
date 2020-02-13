package com.example.manytomanydemo.database.dao;

import com.example.manytomanydemo.database.entity.Subject;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

public interface SubjectDao {
    Subject subjectCreate(Subject subject) throws DataIntegrityViolationException;

    Subject getSubject(String subjectName);

    void deleteSubject(String subjectName);

    void updateSubject(String subjectName, Subject subject);
}
