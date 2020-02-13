package com.example.manytomanydemo.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "subject", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"subject_name"})
})
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade =
                {
                        CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.REFRESH,
                        CascadeType.PERSIST
                },
        targetEntity = Student.class)
    @JoinTable(
            name = "Join_Table",
            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)

    )
    private List<Student> students = new ArrayList<Student>();

}
