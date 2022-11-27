package com.example.serverforunrealapp.servises;

import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public long register(String login, String password,
                            String name, String lastName, String url){
        List<String> logins = userRepo.findLogins();
        if (logins.contains(logins)){
            return 0;
        }
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setLastName(lastName);
        userModel.setPassword(password);
        userModel.setLogin(login);
        userModel.setUrl(url);
        userRepo.save(userModel);

        return userRepo.findUserModelByLogin(login).getId();
    }
    public String login(String login, String password){
        UserModel userModel = null;
        userModel = userRepo.findUserModelByLogin(login);
        if (userModel==null){
            return "no user";
        }else if (userModel.getPassword().equals(password)){
            return userModel.toString();
        }
        return "not correct password";
    }
    public boolean editName(long id, String newName) {
        UserModel userModel = userRepo.getUserModelById(id);
        userModel.setName(newName);
        userRepo.save(userModel);
        return true;
    }
    public boolean editLastName(long id, String newLastName) {
        UserModel userModel = userRepo.getUserModelById(id);
        userModel.setLastName(newLastName);
        userRepo.save(userModel);
        return true;
    }
    public boolean editUrl(long id, String url) {
        UserModel userModel = userRepo.getUserModelById(id);
        userModel.setUrl(url);
        userRepo.save(userModel);
        return true;
    }
}
