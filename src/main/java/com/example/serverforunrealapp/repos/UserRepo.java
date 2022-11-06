package com.example.serverforunrealapp.repos;

import com.example.serverforunrealapp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Long> {
}
