package com.experience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainExperience {
    public static void main(String[] args) {
        System.out.print("Hello im Experience!");
        SpringApplication.run(MainExperience.class, args);
    }
}