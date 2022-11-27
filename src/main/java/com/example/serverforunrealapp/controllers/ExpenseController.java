package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.models.ExpenseModel;
import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.ExpenseRepo;
import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.servises.ExpService;
import com.example.serverforunrealapp.servises.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/expense")
public class ExpenseController {


    private final ExpenseRepo expenseRepo;
    private final ExpService expService;

    public ExpenseController(ExpenseRepo expenseRepo, ExpService expService) {
        this.expenseRepo = expenseRepo;
        this.expService = expService;
    }

    @PostMapping("/add")
    public boolean add(@RequestParam double sum, @RequestParam long time,
                       @RequestParam int day, @RequestParam int month,
                       @RequestParam int year, @RequestParam String login){
        return expService.add(sum, time, day, month, year, login);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam long id){
        expService.expDel(id);
    }
    @PostMapping("/edit")
    public void edit(@RequestParam double sum, @RequestParam long id,
                       @RequestParam String name) {
        expService.edit(sum, id, name);
    }
    @PostMapping("/getSum")
    public double getSum(@RequestParam int id) {
        return expService.getSum(id);
    }
    @GetMapping("/getById/{userId}")
    public List<ExpenseModel> getAll(){
        return expenseRepo.findAll();
    }
    @GetMapping("/get")
    public List<ExpenseModel> getAl(){
        return expenseRepo.findAll();
    }
}