package com.example.javapi.controller;

import com.example.javapi.Service.UserService;
import com.example.javapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class userController {

    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{id_user}")
    public void deleteUser (@PathVariable("id_user") Long id_user ){
        userService.deleteUser(id_user);
    }

    @PutMapping(path = {"{id_user}"})
    public void updateUser(
            @PathVariable("id_user") Long id_user,
            @RequestParam(required = false) String firstName_user,
            @RequestParam(required = false) String lastName_user,
            @RequestParam(required = false) String email_user) {
        userService.updateUser(id_user, firstName_user, lastName_user, email_user);
    }
}
