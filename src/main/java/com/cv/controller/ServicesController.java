package com.cv.controller;

import com.cv.data.Reviews;
import com.cv.data.Services;
import com.cv.services.ReviewsService;
import com.cv.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@Validated
public class ServicesController {

    @Autowired
    private ServicesService service;

    @Autowired
    public ServicesController(ServicesService service) {
        this.service = service;
    }

    // Create a new Experience
    @PostMapping("/users/{userId}")
    public ResponseEntity<Services> create(@PathVariable Long userId, @RequestBody Services obj) {
        Services created = service.create(userId, obj);
        return ResponseEntity.ok(created);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<Services>> getAll() {
        List<Services> obj = service.getAll();
        return ResponseEntity.ok(obj);
    }

    // Get a Experience by ID
    @GetMapping("/{id}")
    public ResponseEntity<Services> getById(@PathVariable Long id) {
        Services obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

    // Update an existing Experience
    @PutMapping("/{id}")
    public ResponseEntity<Services> update(@PathVariable Long id, @RequestBody Services updated) {
        Services obj = service.update(id, updated);
        return ResponseEntity.ok(obj);
    }

    // Delete a Experience
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
