package com.user.controller;

import com.user.data.ExperienceDTO;
import com.user.data.User;

import com.user.data.UserDTO;
import com.user.services.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.user.services.UserService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @Value("${api.base.url.exp}")
    private String apiBaseUrl;
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

//    // Get a User by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO>  getUserWithExperience(@PathVariable Long userId) {
        // Get user data from User database
        User user = userService.getUserById(userId);

        // Call Experience service to get experience data
        String experienceServiceUrl = apiBaseUrl + "/experience/users/" + userId;
        System.out.println(experienceServiceUrl);
        ResponseEntity<ExperienceDTO[]> response = restTemplate.restTemplate().getForEntity(experienceServiceUrl, ExperienceDTO[].class);
        ExperienceDTO[] experiences = response.getBody();

        // Add experience data to user object
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setImage(user.getImage());
        userDTO.setDescription(user.getDescription());
        userDTO.setPosition(user.getPosition());
        userDTO.setExperiences(experiences);

        return ResponseEntity.ok(userDTO);
    }

    // Update an existing User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

    // Delete a User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
