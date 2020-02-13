package com.example.manytomanydemo.controller;

import com.example.manytomanydemo.database.entity.Student;
import com.example.manytomanydemo.dto.StudentDTO;
import com.example.manytomanydemo.service.StudentService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO){
        try {
            studentService.studentCreate(studentDTO);
            return ResponseEntity.ok(studentDTO);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(studentDTO);
        }
    }

    @GetMapping("/student")
    public StudentDTO getStudent(@RequestParam String rollNumber){
        return studentService.getStudent(rollNumber);
    }

    @DeleteMapping("/student/{studentRollNumber}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String studentRollNumber){
        studentService.deleteStudent(studentRollNumber);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/student/{studentRollNumber}")
    public ResponseEntity<Void> updateStudent(@PathVariable String studentRollNumber, @RequestBody StudentDTO studentDto){
        studentService.updateStudent(studentRollNumber, studentDto);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
