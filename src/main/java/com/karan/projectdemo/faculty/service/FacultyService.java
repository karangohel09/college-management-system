package com.karan.projectdemo.faculty.service;

import com.karan.projectdemo.faculty.dto.FacultyDTO;
import com.karan.projectdemo.faculty.mapper.FacultyMapper;
import com.karan.projectdemo.faculty.model.Faculty;
import com.karan.projectdemo.faculty.repo.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepo repo;
    @Autowired
    public FacultyService(FacultyRepo repo) {
        this.repo = repo;
    }
    public FacultyDTO createFaculty(FacultyDTO dto){
        Faculty faculty = FacultyMapper.toentity(dto);
        Faculty savedFaculty = repo.save(faculty);
        return FacultyMapper.todto(savedFaculty);
    }
    public List<FacultyDTO> getAllFaculty(){
        return repo.findAll().stream().map(FacultyMapper::todto).collect(Collectors.toList());
    }
    public FacultyDTO getFacultyByID(int id){
        Faculty faculty = repo.findById(id).orElseThrow(()->new RuntimeException("faculty not found with id"+id));
        return FacultyMapper.todto(faculty);
    }
    public FacultyDTO updateFaculty(int id , FacultyDTO dto){
        Faculty faculty = repo.findById(id).orElseThrow(()->new RuntimeException("faculty not found with id:"+id));
        faculty.setId(dto.getId());
        faculty.setAge(dto.getAge());
        faculty.setName(dto.getName());
        faculty.setSubject(dto.getSubject());
        faculty.setSalary(dto.getSalary());
        Faculty savedfaculty = repo.save(faculty);
        return FacultyMapper.todto(savedfaculty);
    }
    public void deleteFaculty(int id){
        repo.deleteById(id);
    }
}
