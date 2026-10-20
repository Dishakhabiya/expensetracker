package com.example.expensetracker.service;

import com.example.expensetracker.exception.ExpenseNotFoundException;
import com.example.expensetracker.model.AppUser;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepo;
import com.example.expensetracker.repository.UserRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;
    private final UserRepo userRepo;

    public ExpenseService(ExpenseRepo expenseRepo, UserRepo userRepo) {
        this.expenseRepo = expenseRepo;
        this.userRepo = userRepo;
    }

    public Expense saveExpense(Expense expense, String email) {
        AppUser owner = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Ignore a client-supplied ID so creation cannot update an existing expense.
        expense.setId(null);
        expense.setOwner(owner);

        return expenseRepo.save(expense);
    }

    public Expense getByTitleExpense(String title, String email) {
        return expenseRepo.findFirstByTitleAndOwnerEmail(title, email)
                .orElseThrow(() ->
                        new ExpenseNotFoundException(
                                "Expense not found with title: " + title));
    }

    public Page<Expense> getAllExpenses(Pageable pageable, String email) {
        return expenseRepo.findAllByOwnerEmail(email, pageable);
    }

    public Expense getExpenseById(Long id, String email) {
        return expenseRepo.findByIdAndOwnerEmail(id, email)
                .orElseThrow(() ->
                        new ExpenseNotFoundException(
                                "Expense not found with id: " + id));
    }

    public Expense updateExpense(Long id, Expense expense, String email) {
        Expense existing = getExpenseById(id, email);

        existing.setTitle(expense.getTitle());
        existing.setCategory(expense.getCategory());
        existing.setAmount(expense.getAmount());
        existing.setDate(expense.getDate());

        return expenseRepo.save(existing);
    }

    public void deleteExpense(Long id, String email) {
        Expense existing = getExpenseById(id, email);
        expenseRepo.delete(existing);
    }

    public List<Expense> getByCategory(String category, String email) {
        return expenseRepo.findByCategoryAndOwnerEmail(category, email);
    }

    public List<Expense> searchByTitle(String title, String email) {
        return expenseRepo.findByTitleContainingIgnoreCaseAndOwnerEmail(title, email);
    }
}