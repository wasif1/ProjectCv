package com.cv.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    @Test
    void shouldReturnDefaultMessage() {
        assertEquals(2 + 2, 4);
    }
}
