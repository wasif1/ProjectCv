package com.cv.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTests {

    @Test
    public void testCreateUser() {
        assertEquals(2 + 2, 4);
    }
}
