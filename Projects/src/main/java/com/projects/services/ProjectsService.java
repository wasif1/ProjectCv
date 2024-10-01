package com.projects.services;


import com.projects.data.Projects;
import com.projects.data.User;
import com.projects.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {

    @Value("${api.base.url}")
    private String apiBaseUrl;
    @Autowired
    private ProjectsRepository repository;
    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    public ProjectsService(ProjectsRepository repository) {
        this.repository = repository;
    }

    public Projects create(Long userId, Projects data) {
        // API call to User microservice to validate userId
        String userServiceUrl = apiBaseUrl + "/users" + userId;
        ResponseEntity<User> userResponse = restTemplate.restTemplate().getForEntity(userServiceUrl, User.class);

        if (userResponse.getStatusCode() == HttpStatus.OK) {
            // Save if user exists
            data.setUser_id(userId);  // Set the user for this experience
            Projects saved = repository.save(data);
            return ResponseEntity.ok(saved).getBody();
        } else {
            // Handle invalid userId case
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid userId");
        }
    }

    // Get all Experience
    public List<Projects> getAll() {
        return repository.findAll();
    }

    // Get a user by ID
    public Projects getById(Long id) {
        Optional<Projects> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Experience not found with id: " + id);
        }
    }

    // Update an existing Experience
    public Projects update(Long id, Projects data) {
        Projects obj = getById(id); // Fetch the first
        obj.setName(data.getName());
        obj.setSource_url(data.getSource_url());
        obj.setDescription(data.getDescription());
        return repository.save(obj); // Save the updated
    }

    // Delete a Experience
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
