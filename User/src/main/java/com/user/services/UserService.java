package com.user.services;

import com.user.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new User
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    // Update an existing User
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id); // Fetch the user first
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setNumber(updatedUser.getNumber());
        return userRepository.save(user); // Save the updated user
    }

    // Delete a User
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
