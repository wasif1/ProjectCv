package com.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainServices {
    public static void main(String[] args) {
        System.out.print("Hello im Services!");
        SpringApplication.run(MainServices.class, args);
    }
}