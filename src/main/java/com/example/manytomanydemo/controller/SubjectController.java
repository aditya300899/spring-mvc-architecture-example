package com.example.manytomanydemo.controller;

import com.example.manytomanydemo.dto.SubjectDTO;
import com.example.manytomanydemo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @PostMapping("/subject")
    public void addSubject(@RequestBody @Valid SubjectDTO subjectDTO) {
        subjectService.subjectCreate(subjectDTO);
    }


}
