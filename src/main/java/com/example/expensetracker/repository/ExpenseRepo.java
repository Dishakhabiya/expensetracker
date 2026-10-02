package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    Expense findByTitle(String title);

    List<Expense> findByCategory(String category);

    List<Expense> findByTitleContainingIgnoreCase(String title);
}