package com.cv.services;

import com.cv.data.Services;
import com.cv.data.Skills;
import com.cv.data.User;
import com.cv.repository.ServicesRepository;
import com.cv.repository.SkillsRepository;
import com.cv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public SkillsService(SkillsRepository repository) {
        this.repository = repository;
    }

    public Skills create(Long userId, Skills data) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        data.setUser(user);  // Set the user for this experience
        return repository.save(data);
    }

    // Get all Experience
    public List<Skills> getAll() {
        return repository.findAll();
    }

    // Get a user by ID
    public Skills getById(Long id) {
        Optional<Skills> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Experience not found with id: " + id);
        }
    }

    // Update an existing Experience
    public Skills update(Long id, Skills data) {
        Skills obj = getById(id); // Fetch the first
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
