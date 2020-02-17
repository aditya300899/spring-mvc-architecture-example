package com.example.manytomanydemo.database.dao.Impl;

import com.example.manytomanydemo.database.dao.SubjectDao;
import com.example.manytomanydemo.database.entity.Subject;
import com.example.manytomanydemo.database.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    SubjectRepository subjectRepository;

    public Subject subjectCreate(Subject subject) throws DataIntegrityViolationException{
            return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubject(String subjectName) {
        return subjectRepository.findBySubjectName(subjectName);
    }

    @Override
    public void deleteSubject(String subjectName) {
        Subject subject = subjectRepository.findBySubjectName(subjectName);
        subjectRepository.delete(subject);
        return;
    }

    @Override
    public void updateSubject(String subjectName, Subject subject) {
        Subject subject1 = subjectRepository.findBySubjectName(subjectName);
        subject1.setSubjectName(subject.getSubjectName());
        subjectRepository.save(subject1);
        return;
    }


}
