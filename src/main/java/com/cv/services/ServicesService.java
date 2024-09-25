package com.cv.services;

import com.cv.data.Reviews;
import com.cv.data.Services;
import com.cv.data.User;
import com.cv.repository.ReviewsRepository;
import com.cv.repository.ServicesRepository;
import com.cv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    @Autowired
    private ServicesRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ServicesService(ServicesRepository repository) {
        this.repository = repository;
    }

    public Services create(Long userId, Services data) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        data.setUser(user);  // Set the user for this experience
        return repository.save(data);
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
