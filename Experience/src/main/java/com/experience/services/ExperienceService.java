package com.experience.services;


import com.experience.data.Experience;
import com.experience.data.User;
import com.experience.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Value("${api.base.url.user}")
    private String apiBaseUrlUser;
    @Autowired
    private ExperienceRepository repository;
    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    public ExperienceService(ExperienceRepository repository) {
        this.repository = repository;
    }

    public Experience create(Long userId, Experience experience) {

        // API call to User microservice to validate userId
        String userServiceUrl = apiBaseUrlUser + "/users/" + userId;
        System.out.println(userServiceUrl);
        ResponseEntity<User> userResponse = restTemplate.restTemplate().getForEntity(userServiceUrl, User.class);

        if (userResponse.getStatusCode() == HttpStatus.OK) {
            // Save if user exists
            experience.setUser_id(userId);  // Set the user for this experience
            Experience saved = repository.save(experience);
            return ResponseEntity.ok(saved).getBody();
        } else {
            // Handle invalid userId case
            throw new RuntimeException("Experience not found with user id: " + userId);
        }
    }

    // Get all Experience
    public List<Experience> getAll() {
        return repository.findAll();
    }

    // Get a user by ID
    public Experience getById(Long id) {
        Optional<Experience> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Experience not found with id: " + id);
        }
    }

    // Get a user by user_id
    public List<Experience> getByUserId(Long user_id) {
        Optional<List<Experience>> obj = repository.findByUserId(user_id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Experience not found with user_id: " + user_id);
        }
    }

    // Update an existing Experience
    public Experience update(Long id, Experience data) {
        Experience obj = getById(id); // Fetch the first
        obj.setEmployer(data.getEmployer());
        obj.setStart_date(data.getStart_date());
        obj.setEnd_date(data.getEnd_date());
        return repository.save(obj); // Save the updated
    }

    // Delete a Experience
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
