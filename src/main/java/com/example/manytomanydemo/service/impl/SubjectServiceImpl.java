package com.example.manytomanydemo.service.impl;

import com.example.manytomanydemo.database.dao.SubjectDao;
import com.example.manytomanydemo.dto.SubjectDTO;
import com.example.manytomanydemo.service.SubjectService;
import com.example.manytomanydemo.service.transformers.EntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.manytomanydemo.database.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public void subjectCreate(SubjectDTO subjectDTO) {
        Subject subject = convertSubjectDtoToSubjectEntity(subjectDTO);
        Subject createdSubject = subjectDao.subjectCreate(subject);
    }

    private Subject convertSubjectDtoToSubjectEntity(SubjectDTO subjectDTO){
        return EntityTransformer.toSubjectEntity(subjectDTO);
    }
}
