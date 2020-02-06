package com.example.manytomanydemo.controller;


import com.example.manytomanydemo.dto.StudentDTO;
import com.example.manytomanydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@RequestBody @Valid StudentDTO studentDTO){
        studentService.studentCreate(studentDTO);
    }
}
