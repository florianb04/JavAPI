package com.example.javapi.Service;

import com.example.javapi.entity.User;
import com.example.javapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail_user(user.getEmail_user());
        if (userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }
}
