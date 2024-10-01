package com.user.controller;

import com.user.data.*;

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
    private String apiBaseUrlExp;
    @Value("${api.base.url.proj}")
    private String apiBaseUrlProj;
    @Value("${api.base.url.review}")
    private String apiBaseUrlReview;
    @Value("${api.base.url.services}")
    private String apiBaseUrlServices;
    @Value("${api.base.url.skills}")
    private String apiBaseUrlSkills;
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

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO>  getUserWithExperience(@PathVariable Long userId) {
        // Get user data from User database
        User user = userService.getUserById(userId);

        // Call Experience service to get data
        String experienceServiceUrl = apiBaseUrlExp + "/experience/users/" + userId;
        System.out.println(experienceServiceUrl);
        ResponseEntity<ExperienceDTO[]> response = restTemplate.restTemplate().getForEntity(experienceServiceUrl, ExperienceDTO[].class);
        ExperienceDTO[] experiences = response.getBody();

        // Call Projects service to get data
        String projectsServiceUrl = apiBaseUrlProj + "/projects/users/" + userId;
        System.out.println(projectsServiceUrl);
        ResponseEntity<Projects[]> responseProject = restTemplate.restTemplate().getForEntity(projectsServiceUrl, Projects[].class);
        Projects[] projects = responseProject.getBody();

        // Call Reviews service to get data
        String reviewsServiceUrl = apiBaseUrlReview + "/reviews/users/" + userId;
        System.out.println(reviewsServiceUrl);
        ResponseEntity<Reviews[]> responseReviews = restTemplate.restTemplate().getForEntity(reviewsServiceUrl, Reviews[].class);
        Reviews[] reviews = responseReviews.getBody();

        // Call Services to get data
        String servicesServiceUrl = apiBaseUrlServices + "/services/users/" + userId;
        System.out.println(servicesServiceUrl);
        ResponseEntity<Services[]> responseServices = restTemplate.restTemplate().getForEntity(servicesServiceUrl, Services[].class);
        Services[] services = responseServices.getBody();

        // Call Skills to get data
        String skillsServiceUrl = apiBaseUrlSkills + "/skills/users/" + userId;
        System.out.println(skillsServiceUrl);
        ResponseEntity<Skills[]> responseSkills = restTemplate.restTemplate().getForEntity(skillsServiceUrl, Skills[].class);
        Skills[] skills = responseSkills.getBody();

        // Add experience data to user object
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setImage(user.getImage());
        userDTO.setDescription(user.getDescription());
        userDTO.setPosition(user.getPosition());
        userDTO.setExperiences(experiences);
        userDTO.setProjects(projects);
        userDTO.setReviews(reviews);
        userDTO.setServices(services);
        userDTO.setSkills(skills);

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
