package com.skills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainSkills {
    public static void main(String[] args) {
        System.out.print("Hello im Skills!");
        SpringApplication.run(MainSkills.class, args);
    }
}