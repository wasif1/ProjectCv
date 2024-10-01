package com.experience.controller;

import com.experience.data.Experience;
import com.experience.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@Validated
public class ExperienceController {

    @Autowired
    private ExperienceService service;

    @Autowired
    public ExperienceController(ExperienceService service) {
        this.service = service;
    }

    // Create a new Experience
    @PostMapping("/users/{userId}")
    public ResponseEntity<Experience> create(@PathVariable Long userId, @RequestBody Experience obj) {
        Experience created = service.create(userId, obj);
        return ResponseEntity.ok(created);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<Experience>> getAll() {
        List<Experience> obj = service.getAll();
        return ResponseEntity.ok(obj);
    }

    // Get a Experience by ID
    @GetMapping("/{id}")
    public ResponseEntity<Experience> getById(@PathVariable Long id) {
        Experience obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

    // Get a Experience by ID
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Experience>> getUserExpById(@PathVariable Long userId) {
        List<Experience> obj = service.getByUserId(userId);
        return ResponseEntity.ok(obj);
    }

    // Update an existing Experience
    @PutMapping("/{id}")
    public ResponseEntity<Experience> update(@PathVariable Long id, @RequestBody Experience updated) {
        Experience obj = service.update(id, updated);
        return ResponseEntity.ok(obj);
    }

    // Delete a Experience
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
