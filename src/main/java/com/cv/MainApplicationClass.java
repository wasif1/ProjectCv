package com.cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplicationClass {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        SpringApplication.run(MainApplicationClass.class, args);
    }
}