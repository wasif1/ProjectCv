package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainUser {
    public static void main(String[] args) {
        System.out.print("Hello im User!");
        SpringApplication.run(MainUser.class, args);
    }
}