package com.reviews.controller;

import com.reviews.data.Reviews;
import com.reviews.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Validated
public class ReviewsController {

    @Autowired
    private ReviewsService service;

    @Autowired
    public ReviewsController(ReviewsService service) {
        this.service = service;
    }

    // Create a new Experience
    @PostMapping("/users/{userId}")
    public ResponseEntity<Reviews> create(@PathVariable Long userId, @RequestBody Reviews obj) {
        Reviews created = service.create(userId, obj);
        return ResponseEntity.ok(created);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<Reviews>> getAll() {
        List<Reviews> obj = service.getAll();
        return ResponseEntity.ok(obj);
    }

    // Get a Experience by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getById(@PathVariable Long id) {
        Reviews obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

    // Update an existing Experience
    @PutMapping("/{id}")
    public ResponseEntity<Reviews> update(@PathVariable Long id, @RequestBody Reviews updated) {
        Reviews obj = service.update(id, updated);
        return ResponseEntity.ok(obj);
    }

    // Delete a Experience
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
