package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;

    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    public Expense getByTitleExpense(String title) {
        return expenseRepo.findByTitle(title);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expense not found with id: " + id));
    }

    public Expense updateExpense(Long id, Expense expense) {

        Expense existing = getExpenseById(id);

        existing.setTitle(expense.getTitle());
        existing.setCategory(expense.getCategory());
        existing.setAmount(expense.getAmount());
        existing.setDate(expense.getDate());

        return expenseRepo.save(existing);
    }

    public void deleteExpense(Long id) {
        if (!expenseRepo.existsById(id)) {
            throw new RuntimeException("Expense not found with id: " + id);
        }

        expenseRepo.deleteById(id);
    }

    public List<Expense> getByCategory(String category) {
        return expenseRepo.findByCategory(category);
    }

    public List<Expense> searchByTitle(String title) {
        return expenseRepo.findByTitleContainingIgnoreCase(title);
    }
}