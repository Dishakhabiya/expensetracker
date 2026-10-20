package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

 private final ExpenseService expenseService;

 public ExpenseController(ExpenseService expenseService) {
  this.expenseService = expenseService;
 }

 // Create an expense owned by the logged-in user
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public Expense saveExpense(
         @Valid @RequestBody Expense expense,
         Authentication authentication) {
  return expenseService.saveExpense(expense, authentication.getName());
 }

 // Get the logged-in user's expenses with pagination and sorting
 @GetMapping
 public Page<Expense> getAllExpenses(
         Pageable pageable,
         Authentication authentication) {
  return expenseService.getAllExpenses(pageable, authentication.getName());
 }

 // Get one of the logged-in user's expenses by title
 @GetMapping("/title/{title}")
 public Expense getExpenseByTitle(
         @PathVariable String title,
         Authentication authentication) {
  return expenseService.getByTitleExpense(title, authentication.getName());
 }

 // Get one of the logged-in user's expenses by ID
 @GetMapping("/{id}")
 public Expense getExpenseById(
         @PathVariable Long id,
         Authentication authentication) {
  return expenseService.getExpenseById(id, authentication.getName());
 }

 // Update one of the logged-in user's expenses
 @PutMapping("/{id}")
 public Expense updateExpense(
         @PathVariable Long id,
         @Valid @RequestBody Expense expense,
         Authentication authentication) {
  return expenseService.updateExpense(id, expense, authentication.getName());
 }

 // Delete one of the logged-in user's expenses
 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void deleteExpense(
         @PathVariable Long id,
         Authentication authentication) {
  expenseService.deleteExpense(id, authentication.getName());
 }

 // Get the logged-in user's expenses by category
 @GetMapping("/category/{category}")
 public List<Expense> getByCategory(
         @PathVariable String category,
         Authentication authentication) {
  return expenseService.getByCategory(category, authentication.getName());
 }

 // Search the logged-in user's expenses by title
 @GetMapping("/search")
 public List<Expense> searchByTitle(
         @RequestParam String title,
         Authentication authentication) {
  return expenseService.searchByTitle(title, authentication.getName());
 }
}