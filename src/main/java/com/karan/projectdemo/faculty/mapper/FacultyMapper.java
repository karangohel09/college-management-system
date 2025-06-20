package com.karan.projectdemo.faculty.mapper;

import com.karan.projectdemo.faculty.dto.FacultyDTO;
import com.karan.projectdemo.faculty.model.Faculty;

public class FacultyMapper {
    public static FacultyDTO todto(Faculty faculty){
        FacultyDTO dto = new FacultyDTO();
        dto.setId(faculty.getId());
        dto.setAge(faculty.getAge());
        dto.setName(faculty.getName());
        dto.setSubject(faculty.getSubject());
        dto.setSalary(faculty.getSalary());
        return dto;
    }
    public static Faculty toentity(FacultyDTO dto){
        Faculty faculty = new Faculty();
        faculty.setId(dto.getId());
        faculty.setAge(dto.getAge());
        faculty.setName(dto.getName());
        faculty.setSubject(dto.getSubject());
        faculty.setSalary(dto.getSalary());
        return faculty;
    }
}
