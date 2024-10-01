package com.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainProjects {
    public static void main(String[] args) {
        System.out.print("Hello im Projects!");
        SpringApplication.run(MainProjects.class, args);
    }
}