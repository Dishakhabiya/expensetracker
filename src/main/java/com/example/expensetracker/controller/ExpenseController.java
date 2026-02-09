package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.expensetracker.service.ExpenseService;

import java.util.List;

@RestController
public class ExpenseController {

 @Autowired
 ExpenseService expenseService;


 @PostMapping("/expense")
 void saveExpense(@RequestBody Expense expense){
  expenseService.saveExpense(expense);
 }

 @GetMapping("/getexpense/{title}")
 Expense getExpenseByTitle(@PathVariable String title){
  return expenseService.getByTitleExpense(title);
 }

 
 @GetMapping("/getAllExpenses")
 List<Expense> getAllExpenses(){
  return expenseService.getAllExpenses();

 }

}
