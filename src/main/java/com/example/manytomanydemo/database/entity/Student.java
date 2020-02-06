package com.example.manytomanydemo.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_father_name")
    private String studentFatherName;

    @Column(name = "student_mother_name")
    private String studentMotherName;

    @Column(name = "student_dob")
    private String studentDob;

    @Column(name = "student_phone_number")
    private Long studentPhoneNumber;

    @Column(name = "student_address")
    private String studentAddress;
}
