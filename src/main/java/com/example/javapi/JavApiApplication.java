package com.example.javapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class JavApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavApiApplication.class, args);
    }

}
