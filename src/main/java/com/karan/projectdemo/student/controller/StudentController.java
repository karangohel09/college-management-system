package com.karan.projectdemo.student.controller;

import com.karan.projectdemo.student.dto.StudentDTO;
import com.karan.projectdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String home() {
        return "index";  // Corresponds to index.html or index.html in templates
    }
    @GetMapping("")
    public List<StudentDTO> getAllStudent(){
        return service.getAllStudent();
    }
    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable int id){
        return service.getByID(id);
    }
    @PostMapping("/")
    public StudentDTO createStudent(@RequestBody StudentDTO dto){
        return  service.createStudent(dto);
    }
    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable int id,@RequestBody StudentDTO dto){
        return service.updateStudent(id,dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.deleteStudent(id);
    }
}
