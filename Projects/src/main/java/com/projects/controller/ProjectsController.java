package com.projects.controller;


import com.projects.data.Projects;
import com.projects.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Validated
public class ProjectsController {

    @Autowired
    private ProjectsService service;

    @Autowired
    public ProjectsController(ProjectsService service) {
        this.service = service;
    }

    // Create a new Experience
    @PostMapping("/users/{userId}")
    public ResponseEntity<Projects> create(@PathVariable Long userId, @RequestBody Projects obj) {
        Projects created = service.create(userId, obj);
        return ResponseEntity.ok(created);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<Projects>> getAll() {
        List<Projects> obj = service.getAll();
        return ResponseEntity.ok(obj);
    }

    // Get a Experience by ID
    @GetMapping("/{id}")
    public ResponseEntity<Projects> getById(@PathVariable Long id) {
        Projects obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

    // Get a Projects by User ID
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Projects>> getUserProjById(@PathVariable Long userId) {
        List<Projects> obj = service.getByUserId(userId);
        return ResponseEntity.ok(obj);
    }

    // Update an existing Experience
    @PutMapping("/{id}")
    public ResponseEntity<Projects> update(@PathVariable Long id, @RequestBody Projects updated) {
        Projects obj = service.update(id, updated);
        return ResponseEntity.ok(obj);
    }

    // Delete a Experience
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
