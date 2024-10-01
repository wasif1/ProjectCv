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

    @Value("${api.base.url.user}")
    private String apiBaseUrlUser;
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
        String userServiceUrl = apiBaseUrlUser + "/users/" + userId;
        System.out.println(userServiceUrl);
        ResponseEntity<User> userResponse = restTemplate.restTemplate().getForEntity(userServiceUrl, User.class);

        if (userResponse.getStatusCode() == HttpStatus.OK) {
            // Save if user exists
            data.setUser_id(userId);  // Set the user for this Projects
            Projects saved = repository.save(data);
            return ResponseEntity.ok(saved).getBody();
        } else {
            // Handle invalid userId case
            throw new RuntimeException("Projects not found with user id: " + userId);
        }
    }

    // Get all Projects
    public List<Projects> getAll() {
        return repository.findAll();
    }

    // Get a user by ID
    public Projects getById(Long id) {
        Optional<Projects> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Projects not found with id: " + id);
        }
    }


    // Get a user by user_id
    public List<Projects> getByUserId(Long user_id) {
        Optional<List<Projects>> obj = repository.findByUserId(user_id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Projects not found with user_id: " + user_id);
        }
    }

    // Update an existing Projects
    public Projects update(Long id, Projects data) {
        Projects obj = getById(id); // Fetch the first
        obj.setName(data.getName());
        obj.setSource_url(data.getSource_url());
        obj.setDescription(data.getDescription());
        return repository.save(obj); // Save the updated
    }

    // Delete a Projects
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
