package com.example.manytomanydemo.controller;

import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.dto.ResponseDTO;
import com.example.manytomanydemo.dto.SubjectDTO;
import com.example.manytomanydemo.request.AddStudentToSubjectRequest;
import com.example.manytomanydemo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public ResponseEntity<?> addSubject(@RequestBody @Valid SubjectDTO subjectDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            subjectService.subjectCreate(subjectDTO);
            return ResponseEntity.ok(subjectDTO);
        }
        catch(DataIntegrityViolationException e){

            responseDTO.setErrorMessage("Subject already exists.");
            responseDTO.setErrorCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping("/subject")
    public ResponseEntity<?> getSubject(@RequestParam String name){
        try{
            SubjectDTO subjectDTO = subjectService.getSubject(name);
            return ResponseEntity.ok(subjectDTO);
        }catch (NullPointerException e){
            return ResponseEntity.badRequest().body("The subject  doesn't exist.");
        }

    }

    @PostMapping("/subject/student")
    public ResponseEntity<?> addStudentToSubject(@RequestBody AddStudentToSubjectRequest request){
        try{
            subjectService.addStudentToSubject(request);
            return ResponseEntity.ok("Student added to subject");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Student not added.");
        }
    }

    @DeleteMapping("/subject/{subjectName}")
    public ResponseEntity<?> deleteSubject(@PathVariable String subjectName){
        try{
            subjectService.deleteSubject(subjectName);
            return ResponseEntity.ok("Subject deleted");
        }catch (NullPointerException e){
            return ResponseEntity.badRequest().body("Subject not Found.");
        }

    }

    @PutMapping("/subject/{subjectName}")
    public ResponseEntity<?> updateSubject(@PathVariable String subjectName, @RequestBody SubjectDTO subjectDto){
        try{
            subjectService.updateSubject(subjectName, subjectDto);
            return ResponseEntity.ok(subjectDto);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Subject not found.");
        }
    }

    @DeleteMapping("subject/{subjectName}/student/{studentRollNumber}")
    public ResponseEntity<?> deleteStudentFromSubject(@PathVariable String subjectName, @PathVariable String studentRollNumber){
        try {
            subjectService.deleteStudentFromSubject(subjectName, studentRollNumber);
            return ResponseEntity.ok("Student deleted from subject successfully.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Operation wasn't successful.");
        }
    }

    @GetMapping("subject/students")
    public List<Student> getStudentsOfSubject(@RequestParam String subjectName){
        return subjectService.getStudentsOfSubject(subjectName);
    }
}
