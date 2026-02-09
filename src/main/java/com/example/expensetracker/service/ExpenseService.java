package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepo expenseRepo;
    public void saveExpense(Expense expense){
        expenseRepo.save(expense);
    }
   public Expense getByTitleExpense(String title){
       return expenseRepo.getByTitle(title);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepo.getAll();
    }


}
