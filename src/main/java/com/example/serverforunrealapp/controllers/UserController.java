package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public void register(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam String name,
                         @RequestParam String lastName){
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setLastName(lastName);
        userModel.setPassword(password);
        userModel.setLogin(login);
        userRepo.save(userModel);
    }
}
