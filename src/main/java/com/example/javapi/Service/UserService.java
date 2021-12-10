package com.example.javapi.Service;

import com.example.javapi.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //@GetMapping
    public List<User> getUsers() {
        return List.of(
                new User(
                        1,
                        "aaa",
                        "AAA",
                        "aaa@aaa;fr",
                        "aaa"
                )
        );
    }
}
