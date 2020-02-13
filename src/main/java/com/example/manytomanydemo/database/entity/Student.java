package com.example.manytomanydemo.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_name", "student_father_name", "student_mother_name", "student_dob"})
})
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

    @Column(name = "roll_number")
    private String studentRollNumber;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Subject.class)
    @JoinTable(
            name = "Join_Table",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)

    )
    private List<Subject> subjects = new ArrayList<Subject>();
}
