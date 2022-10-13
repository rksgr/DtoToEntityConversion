package com.example.dtotoentityconversion.repository;

import com.example.dtotoentityconversion.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
