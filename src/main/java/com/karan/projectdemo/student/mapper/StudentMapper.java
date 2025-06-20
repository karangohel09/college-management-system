package com.karan.projectdemo.student.mapper;

import com.karan.projectdemo.student.dto.StudentDTO;
import com.karan.projectdemo.student.model.Student;

public class StudentMapper {

    public static StudentDTO toDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setMarks(student.getMarks());
        dto.setRoll_no(student.getRoll_no());
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setMarks(dto.getMarks());
        student.setRoll_no(dto.getRoll_no());
        return student;
    }
}
