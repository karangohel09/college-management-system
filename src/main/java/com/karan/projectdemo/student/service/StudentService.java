package com.karan.projectdemo.student.service;

import com.karan.projectdemo.student.dto.StudentDTO;
import com.karan.projectdemo.student.mapper.StudentMapper;
import com.karan.projectdemo.student.model.Student;
import com.karan.projectdemo.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepo repo;
    @Autowired
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }
    public StudentDTO createStudent(StudentDTO dto){
        Student student = StudentMapper.toEntity(dto);
        Student savedstudent = repo.save(student);
        return StudentMapper.toDto(savedstudent);
    }
    public List<StudentDTO> getAllStudent(){
        return repo.findAll().stream().map(StudentMapper::toDto).collect(Collectors.toList());
    }
    public StudentDTO getByID(int id){
        Student student = repo.findById(id).orElseThrow(()->new RuntimeException("student not found with id"+id));
        return StudentMapper.toDto(student);
    }
    public StudentDTO updateStudent(int id,StudentDTO dto){
        Student student = repo.findById(id).orElseThrow(()->new RuntimeException("student not found with id"+id));
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setMarks(dto.getMarks());
        student.setRoll_no(dto.getRoll_no());
        Student savedstudent = repo.save(student);
        return StudentMapper.toDto(savedstudent);
    }
    public void deleteStudent(int id){
        repo.deleteById(id);
    }
}
