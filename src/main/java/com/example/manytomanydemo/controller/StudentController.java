package com.example.manytomanydemo.controller;
import com.example.manytomanydemo.database.entity.Subject;
import com.example.manytomanydemo.dto.StudentDTO;
import com.example.manytomanydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentDTO studentDTO){
        try {
            studentService.studentCreate(studentDTO);
            return ResponseEntity.ok(studentDTO);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("The student already exists.");
        }
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudent(@RequestParam String rollNumber){
        try {
            return ResponseEntity.ok(studentService.getStudent(rollNumber));
        }catch (NullPointerException e){
            return ResponseEntity.badRequest().body("the student doesn't exist.");
        }
    }

    @DeleteMapping("/student/{studentRollNumber}")
    public ResponseEntity<?> deleteStudent(@PathVariable String studentRollNumber){
        try {
            studentService.deleteStudent(studentRollNumber);
            return ResponseEntity.ok("Student successfully deleted.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Student doesn't exist by this roll number.");
        }
    }

    @PutMapping("/student/{studentRollNumber}")
    public ResponseEntity<?> updateStudent(@PathVariable String studentRollNumber, @RequestBody StudentDTO studentDto){
        try {
            studentService.updateStudent(studentRollNumber, studentDto);
            return ResponseEntity.ok("Student updated");
        }catch (NullPointerException e){
            return ResponseEntity.badRequest().body("Student doesn't exist.");
        }
    }

    @GetMapping("/student/subjects")
    public List<Subject> getSubjectsOfStudent(@RequestParam String studentRollNumber){
        return studentService.getSubjectsOfStudent(studentRollNumber);
    }
}
