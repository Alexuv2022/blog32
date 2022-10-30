package com.example.blog32.controller;

import com.example.blog32.entity.UserEntity;
import com.example.blog32.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signin")
    String signIn(@ModelAttribute UserEntity user) {
        if (userRepo.findUserEntityByLogin(user.getLogin()) != null) return "Такой логин уже есть";
            userRepo.save(user);
            return "OK";
    }
}
