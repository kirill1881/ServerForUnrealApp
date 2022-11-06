package com.example.serverforunrealapp.repos;

import com.example.serverforunrealapp.models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<ExpenseModel, Long> {
}
