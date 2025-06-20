package com.karan.projectdemo.faculty.repo;

import com.karan.projectdemo.faculty.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty , Integer> {
}
