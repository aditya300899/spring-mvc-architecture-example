package com.example.manytomanydemo.database.repository;

import com.example.manytomanydemo.database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentRollNumber(String studentRollNumber);
}
