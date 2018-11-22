package com.makers.chitterchallenge.controller;

import com.makers.chitterchallenge.model.Chitter;
import com.makers.chitterchallenge.model.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import com.makers.chitterchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User user(@Valid @RequestBody User user) {
        user.setPasswordHash(BCrypt.hashpw(user.getPasswordHash(), BCrypt.gensalt()));
        return userRepository.save(user);
    }

//    @PostMapping("/api/users")
//    public @Valid User User(@Valid @RequestBody User user) {
//        user.setPasswordHash(BCrypt.hashpw(user.getPasswordHash(), BCrypt.gensalt()));
//         return userRepository.save(user);
//    }
}
