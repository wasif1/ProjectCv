package com.cv.test;

import com.cv.data.User;
import com.cv.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {User.class, UserService.class})
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
        User user = new User(0L,"John Doe", "john.doe@example.com", "123456789", "","","","");
        User createdUser = userService.createUser(user);
        assertNotNull(createdUser.getId());
        assertEquals("John Doe", createdUser.getName());
    }
}
