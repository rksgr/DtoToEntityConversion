package com.example.dtotoentityconversion.controller;

import com.example.dtotoentityconversion.converter.StudentConverter;
import com.example.dtotoentityconversion.dto.StudentDto;
import com.example.dtotoentityconversion.entity.Student;
import com.example.dtotoentityconversion.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentConverter studentConverter;

    @GetMapping("/findAll")
    public List<StudentDto> findAll(){
        List<Student> allStudList = studentRepository.findAll();
        return studentConverter.entityToDto(allStudList);
    }
    @GetMapping("/find/{ID}")
    public StudentDto findById(@PathVariable(value="ID") Long id){
        Student studentById = studentRepository.findById(id).orElse(null);
        return studentConverter.entityToDto(studentById);
    }

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto studentDto){
        Student student = studentConverter.dtoToEntity(studentDto);
        student = studentRepository.save(student);
        return studentConverter.entityToDto(student);
    }
}
