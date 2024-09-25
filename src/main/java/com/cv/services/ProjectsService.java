package com.cv.services;

import com.cv.data.Experience;
import com.cv.data.Projects;
import com.cv.data.User;
import com.cv.repository.ProjectsRepository;
import com.cv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {

    @Autowired
    private ProjectsRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ProjectsService(ProjectsRepository repository) {
        this.repository = repository;
    }

    public Projects create(Long userId, Projects data) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        data.setUser(user);  // Set the user for this experience
        return repository.save(data);
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
