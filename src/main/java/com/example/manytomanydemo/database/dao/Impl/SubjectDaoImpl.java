package com.example.manytomanydemo.database.dao.Impl;

import com.example.manytomanydemo.database.dao.SubjectDao;
import com.example.manytomanydemo.database.entity.Subject;
import com.example.manytomanydemo.database.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    SubjectRepository subjectRepository;
    @Transactional
    public Subject subjectCreate(Subject subject){
        return subjectRepository.save(subject);
    }
}
