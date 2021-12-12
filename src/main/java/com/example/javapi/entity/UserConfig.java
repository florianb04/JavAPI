package com.example.javapi.entity;

import com.example.javapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner (UserRepository repository) {
        return args -> {
            User aaa = new User(
                    "aaa",
                    "AAA",
                    "aaa@aaa.fr",
                    "aaa"
            );

            User bbb = new User(
                    "bbb",
                    "BBB",
                    "bbb@bbb.fr",
                    "bbb"
            );

            repository.saveAll(List.of(aaa, bbb)
            );
        };
    }
}
