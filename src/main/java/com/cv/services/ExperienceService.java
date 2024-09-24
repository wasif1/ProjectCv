package com.cv.services;

import com.cv.data.Experience;
import com.cv.data.User;
import com.cv.repository.ExperienceRepository;
import com.cv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ExperienceService(ExperienceRepository repository) {
        this.repository = repository;
    }

    public Experience create(Long userId, Experience experience) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        experience.setUser(user);  // Set the user for this experience
        return repository.save(experience);
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
