package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.servises.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepo userRepo;

    private final UserService userService;

    public UserController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @PostMapping("/register")
    public long register(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam String name,
                         @RequestParam String lastName,
                            @RequestParam String url){
        return userService.register(login, password, name, lastName, url);
    }

    @PostMapping("/login")
    public String login(@RequestParam String login,
                        @RequestParam String password){
        return userService.login(login, password);
    }

    @GetMapping("/get")
    public String getUser(){
        return userRepo.findAll().toString();
    }

    @PostMapping("/editName")
    public boolean editName( @RequestParam long id, @RequestParam String newName) {
        return userService.editName(id, newName);
    }
    @PostMapping("/editLastName")
    public boolean editLastName( @RequestParam long id, @RequestParam String newLastName) {
        return userService.editLastName(id, newLastName);
    }
    @PostMapping("/editUrl")
    public boolean editUrl( @RequestParam long id, @RequestParam String url) {
        return userService.editUrl(id, url);
    }
}
