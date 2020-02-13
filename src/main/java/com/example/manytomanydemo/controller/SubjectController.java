package com.example.manytomanydemo.controller;

import com.example.manytomanydemo.dto.SubjectDTO;
import com.example.manytomanydemo.request.AddStudentToSubjectRequest;
import com.example.manytomanydemo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public ResponseEntity<SubjectDTO> addSubject(@RequestBody @Valid SubjectDTO subjectDTO) {
        try{
            subjectService.subjectCreate(subjectDTO);
            return ResponseEntity.ok(subjectDTO);
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/subject")
    public SubjectDTO getSubject(@RequestParam String name){
        return subjectService.getSubject(name);
    }

    @PostMapping("/subject/student")
    public ResponseEntity<Void> addStudentToSubject(@RequestBody AddStudentToSubjectRequest request){
        subjectService.addStudentToSubject(request);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/subject/{subjectName}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String subjectName){
        subjectService.deleteSubject(subjectName);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/subject/{subjectName}")
    public ResponseEntity<Void> updateSubject(@PathVariable String subjectName, @RequestBody SubjectDTO subjectDto){
        subjectService.updateSubject(subjectName, subjectDto);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("subject/{subjectName}/student/{studentRollNumber}")
    public ResponseEntity<Void> deleteStudentFromSubject(@PathVariable String subjectName, @PathVariable String studentRollNumber){
        subjectService.deleteStudentFromSubject(subjectName, studentRollNumber);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
