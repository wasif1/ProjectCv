package com.cv.services;

import com.cv.data.Projects;
import com.cv.data.Reviews;
import com.cv.data.User;
import com.cv.repository.ProjectsRepository;
import com.cv.repository.ReviewsRepository;
import com.cv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ReviewsService(ReviewsRepository repository) {
        this.repository = repository;
    }

    public Reviews create(Long userId, Reviews data) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        data.setUser(user);  // Set the user for this experience
        return repository.save(data);
    }

    // Get all Experience
    public List<Reviews> getAll() {
        return repository.findAll();
    }

    // Get a user by ID
    public Reviews getById(Long id) {
        Optional<Reviews> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Experience not found with id: " + id);
        }
    }

    // Update an existing Experience
    public Reviews update(Long id, Reviews data) {
        Reviews obj = getById(id); // Fetch the first
        obj.setName(data.getName());
        obj.setEmployer(data.getEmployer());
        obj.setReview(data.getReview());
        return repository.save(obj); // Save the updated
    }

    // Delete a Experience
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
