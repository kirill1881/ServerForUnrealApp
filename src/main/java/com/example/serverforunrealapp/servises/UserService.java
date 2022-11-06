package com.example.serverforunrealapp.servises;

import com.example.serverforunrealapp.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String login(String login, String password){

    }
}
