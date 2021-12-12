package com.example.javapi.Service;

import com.example.javapi.entity.User;
import com.example.javapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public void deleteUser(Long id_user) {
        boolean exists = userRepository.existsById(id_user);
        if (!exists){
            throw new IllegalStateException("user with id :" + id_user + "does not exists");
        }
        userRepository.deleteById(id_user);
    }

    @Transactional
    public void updateUser(Long id_user, String firstName_user, String lastName_user, String email_user) {
        User user = userRepository.findById(id_user).orElseThrow(() -> new IllegalStateException("user with id " + id_user + "does not exists"));

        //First name
        if (firstName_user != null && firstName_user.length() > 0 && !Objects.equals(user.getFirstName_user(), firstName_user)) {
            user.setFirstName_user(firstName_user);
        }

        //Last name
        if (lastName_user != null && lastName_user.length() > 0 && !Objects.equals(user.getLastName_user(), lastName_user)) {
            user.setLastName_user(lastName_user);
        }

        //email
        if (email_user != null && email_user.length() > 0 && !Objects.equals(user.getEmail_user(), email_user)) {
            Optional<User> userOptional = userRepository.findUserByEmail_user(email_user);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail_user(email_user);
        }
    }
}
