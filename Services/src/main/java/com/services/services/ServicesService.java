package com.services.services;


import com.services.data.Services;
import com.services.repository.ServicesRepository;
import com.user.data.User;
import com.user.repository.UserRepository;
import com.user.services.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    @Value("${api.base.url}")
    private String apiBaseUrl;
    @Autowired
    private ServicesRepository repository;
    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    public ServicesService(ServicesRepository repository) {
        this.repository = repository;
    }

    public Services create(Long userId, Services data) {
        // API call to User microservice to validate userId
        String userServiceUrl = apiBaseUrl + "/users" + userId;
        ResponseEntity<User> userResponse = restTemplate.restTemplate().getForEntity(userServiceUrl, User.class);

        if (userResponse.getStatusCode() == HttpStatus.OK) {
            // Save if user exists
            data.setUser_id(userId);  // Set the user for this experience
            Services saved = repository.save(data);
            return ResponseEntity.ok(saved).getBody();
        } else {
            // Handle invalid userId case
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid userId");
        }
    }

    // Get all Experience
    public List<Services> getAll() {
        return repository.findAll();
    }

    // Get a user by ID
    public Services getById(Long id) {
        Optional<Services> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Experience not found with id: " + id);
        }
    }

    // Update an existing Experience
    public Services update(Long id, Services data) {
        Services obj = getById(id); // Fetch the first
        obj.setName(data.getName());
        obj.setDescription(data.getDescription());
        obj.setImage(data.getImage());
        return repository.save(obj); // Save the updated
    }

    // Delete a Experience
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
