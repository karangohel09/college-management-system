package com.karan.projectdemo.root.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
public class RootRedirectController {
    @GetMapping("/")
    public ResponseEntity<Void> redirectToStudentsApi() {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/students")
                .build()
                .toUri();
        return ResponseEntity.status(302).location(uri).build();
    }

    // Optional: Redirect /faculties-ui to /api/faculties
    @GetMapping("/faculties-ui")
    public ResponseEntity<Void> redirectToFacultiesApi() {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/faculties")
                .build()
                .toUri();
        return ResponseEntity.status(302).location(uri).build();
    }

    // Optional: Redirect /students-ui to /api/students
    @GetMapping("/students-ui")
    public ResponseEntity<Void> redirectToStudentsAgain() {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/students")
                .build()
                .toUri();
        return ResponseEntity.status(302).location(uri).build();
    }
}
