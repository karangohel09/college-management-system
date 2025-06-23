package com.karan.projectdemo.faculty.controller;

import com.karan.projectdemo.faculty.dto.FacultyDTO;
import com.karan.projectdemo.faculty.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {
    private final FacultyService service;
    @Autowired
    public FacultyController(FacultyService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String home() {
        return "index";  // Corresponds to index.html or index.html in templates
    }
    @GetMapping("")
    public List<FacultyDTO> getAllFaculty(){
        return service.getAllFaculty();
    }
    @GetMapping("/{id}")
    public FacultyDTO getFacutlyByID(@PathVariable int id){
        return service.getFacultyByID(id);
    }
    @PostMapping("")
    public FacultyDTO createNewFaculty(@RequestBody FacultyDTO dto){
        return service.createFaculty(dto);
    }
    @PutMapping("/{id}")
    public FacultyDTO updateFaculty(@PathVariable int id , @RequestBody FacultyDTO dto){
        return service.updateFaculty(id,dto);
    }
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable int id){
        service.deleteFaculty(id);
    }
}
