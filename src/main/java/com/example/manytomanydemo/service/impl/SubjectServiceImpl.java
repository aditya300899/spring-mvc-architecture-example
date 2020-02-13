package com.example.manytomanydemo.service.impl;

import com.example.manytomanydemo.database.dao.StudentDao;
import com.example.manytomanydemo.database.dao.SubjectDao;
import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.dto.SubjectDTO;
import com.example.manytomanydemo.request.AddStudentToSubjectRequest;
import com.example.manytomanydemo.service.SubjectService;
import com.example.manytomanydemo.service.transformers.DtoTransformer;
import com.example.manytomanydemo.service.transformers.EntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.example.manytomanydemo.database.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private StudentDao studentDao;


    @Override
    public void subjectCreate(SubjectDTO subjectDTO) throws DataIntegrityViolationException {
            Subject subject = convertSubjectDtoToSubjectEntity(subjectDTO);
            Subject createdSubject = subjectDao.subjectCreate(subject);
//        }catch (Exception e){
//            System.out.println("Hello there >>>>>>>");
//        }
    }

    @Override
    public SubjectDTO getSubject(String subjectName) {
        Subject subject = subjectDao.getSubject(subjectName);
        SubjectDTO subjectDTO = convertSubjectEntityToSubjectDto(subject);
        return subjectDTO;
    }

    @Override
    public void addStudentToSubject(AddStudentToSubjectRequest request) {
        Subject subject = subjectDao.getSubject(request.getSubjectName());
        Student student = studentDao.getStudent(request.getStudentRollNumber());
        subject.getStudents().add(student);
        subjectDao.subjectCreate(subject);
    }

    @Override
    public void deleteSubject(String subjectName) {
        subjectDao.deleteSubject(subjectName);
        return;

    }

    @Override
    public void updateSubject(String subjectName, SubjectDTO subjectDto) {
        Subject subject = convertSubjectDtoToSubjectEntity(subjectDto);
        subjectDao.updateSubject(subjectName, subject);
        return;
    }

    @Override
    public void deleteStudentFromSubject(String subjectName, String studentRollNumber) {
        Subject subject = subjectDao.getSubject(subjectName);
        Student student = studentDao.getStudent(studentRollNumber);
        subject.getStudents().remove(student);
        subjectDao.subjectCreate(subject);
        return;
    }

    private SubjectDTO convertSubjectEntityToSubjectDto(Subject subject) {
        return DtoTransformer.toSubjectDto(subject);
    }

    private Subject convertSubjectDtoToSubjectEntity(SubjectDTO subjectDTO){
        return EntityTransformer.toSubjectEntity(subjectDTO);
    }

}
