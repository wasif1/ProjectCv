package com.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainReviews {
    public static void main(String[] args) {
        System.out.print("Hello im Reviews!");
        SpringApplication.run(MainReviews.class, args);
    }
}