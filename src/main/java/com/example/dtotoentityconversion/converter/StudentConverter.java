package com.example.dtotoentityconversion.converter;

import com.example.dtotoentityconversion.dto.StudentDto;
import com.example.dtotoentityconversion.entity.Student;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public StudentDto entityToDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setUserName(student.getUsername());
        studentDto.setPassword(student.getPassword());
        return studentDto;
    }

    public List<StudentDto> entityToDto(List<Student> studList){
        return studList.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    public Student dtoToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setUsername(studentDto.getUserName());
        student.setPassword(studentDto.getPassword());
        return student;
    }

    public List<Student> dtoToEntity(List<StudentDto> studentDtoList){
        return studentDtoList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
