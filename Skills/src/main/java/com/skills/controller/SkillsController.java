package com.skills.controller;

import com.skills.data.Skills;
import com.skills.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Validated
public class SkillsController {

    @Autowired
    private SkillsService service;

    @Autowired
    public SkillsController(SkillsService service) {
        this.service = service;
    }

    // Create a new Experience
    @PostMapping("/users/{userId}")
    public ResponseEntity<Skills> create(@PathVariable Long userId, @RequestBody Skills obj) {
        Skills created = service.create(userId, obj);
        return ResponseEntity.ok(created);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<Skills>> getAll() {
        List<Skills> obj = service.getAll();
        return ResponseEntity.ok(obj);
    }

    // Get a Experience by ID
    @GetMapping("/{id}")
    public ResponseEntity<Skills> getById(@PathVariable Long id) {
        Skills obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

    // Update an existing Experience
    @PutMapping("/{id}")
    public ResponseEntity<Skills> update(@PathVariable Long id, @RequestBody Skills updated) {
        Skills obj = service.update(id, updated);
        return ResponseEntity.ok(obj);
    }

    // Delete a Experience
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
