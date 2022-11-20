package com.example.serverforunrealapp.servises;

import com.example.serverforunrealapp.models.ExpenseModel;
import com.example.serverforunrealapp.repos.ExpenseRepo;
import com.example.serverforunrealapp.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class ExpService {
    private final ExpenseRepo expenseRepo;
    private final UserRepo userRepo;

    public ExpService(ExpenseRepo expenseRepo, UserRepo userRepo) {
        this.expenseRepo = expenseRepo;
        this.userRepo = userRepo;
    }

    public void expDel(long id){
        expenseRepo.deleteById(id);
    }

    public boolean add(double sum, long time, int day, int month, int year, String login) {
        ExpenseModel expenseModel = new ExpenseModel();
        expenseModel.setSum(sum);
        expenseModel.setUserModel(userRepo.findUserModelByLogin(login));
        expenseModel.setTime(time);
        expenseModel.setDay(day);
        expenseModel.setMonth(month);
        expenseModel.setYear(year);
        expenseRepo.save(expenseModel);
        return true;
    }
    public void edit(double sum, long id, String name) {
        ExpenseModel expenseModel = expenseRepo.getExpenseModelById(id);
        expenseModel.setSum(sum);
        expenseModel.setName(name);
        expenseRepo.save(expenseModel);
    }

    public double getSum(int mory) {
        if (mory > 1000) return expenseRepo.findExpenseModelByYear(mory).getSum();
        return expenseRepo.findExpenseModelByMonth(mory).getSum();
    }
}
