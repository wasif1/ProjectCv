package com.reviews.services;

import com.reviews.data.Reviews;
import com.reviews.data.User;
import com.reviews.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {

    @Value("${api.base.url.user}")
    private String apiBaseUrlUser;
    @Autowired
    private ReviewsRepository repository;
    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    public ReviewsService(ReviewsRepository repository) {
        this.repository = repository;
    }

    public Reviews create(Long userId, Reviews data) {
        // API call to User microservice to validate userId
        String userServiceUrl = apiBaseUrlUser + "/users/" + userId;
        System.out.println(userServiceUrl);
        ResponseEntity<User> userResponse = restTemplate.restTemplate().getForEntity(userServiceUrl, User.class);

        if (userResponse.getStatusCode() == HttpStatus.OK) {
            // Save if user exists
            data.setUser_id(userId);  // Set the user for this Reviews
            Reviews saved = repository.save(data);
            return ResponseEntity.ok(saved).getBody();
        } else {
            // Handle invalid userId case
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid userId");
        }
    }

    // Get all Reviews
    public List<Reviews> getAll() {
        return repository.findAll();
    }

    // Get a user by ID
    public Reviews getById(Long id) {
        Optional<Reviews> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Reviews not found with id: " + id);
        }
    }

    // Get a user by user_id
    public List<Reviews> getByUserId(Long user_id) {
        Optional<List<Reviews>> obj = repository.findByUserId(user_id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Reviews not found with user_id: " + user_id);
        }
    }

    // Update an existing Reviews
    public Reviews update(Long id, Reviews data) {
        Reviews obj = getById(id); // Fetch the first
        obj.setName(data.getName());
        obj.setEmployer(data.getEmployer());
        obj.setReview(data.getReview());
        return repository.save(obj); // Save the updated
    }

    // Delete a Reviews
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
