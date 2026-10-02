package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

 private final ExpenseService expenseService;

 public ExpenseController(ExpenseService expenseService) {
  this.expenseService = expenseService;
 }

 // Create expense
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public Expense saveExpense(@Valid @RequestBody Expense expense) {
  return expenseService.saveExpense(expense);
 }

 // Get all expenses with pagination and sorting
 @GetMapping
 public Page<Expense> getAllExpenses(Pageable pageable) {
  return expenseService.getAllExpenses(pageable);
 }

 // Get expense by title
 @GetMapping("/title/{title}")
 public Expense getExpenseByTitle(@PathVariable String title) {
  return expenseService.getByTitleExpense(title);
 }

 // Get expense by ID
 @GetMapping("/{id}")
 public Expense getExpenseById(@PathVariable Long id) {
  return expenseService.getExpenseById(id);
 }

 // Update expense
 @PutMapping("/{id}")
 public Expense updateExpense(
         @PathVariable Long id,
         @Valid @RequestBody Expense expense) {
  return expenseService.updateExpense(id, expense);
 }

 // Delete expense
 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void deleteExpense(@PathVariable Long id) {
  expenseService.deleteExpense(id);
 }

 // Get expenses by category
 @GetMapping("/category/{category}")
 public List<Expense> getByCategory(@PathVariable String category) {
  return expenseService.getByCategory(category);
 }

 // Search expenses by title
 @GetMapping("/search")
 public List<Expense> searchByTitle(@RequestParam String title) {
  return expenseService.searchByTitle(title);
 }
}