package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    Expense findByTitle(String title);

    List<Expense> findByCategory(String category);

    List<Expense> findByTitleContainingIgnoreCase(String title);
    Optional<Expense> findFirstByTitleAndOwnerEmail(String title, String email);

    List<Expense> findByCategoryAndOwnerEmail(String category, String email);

    List<Expense> findByTitleContainingIgnoreCaseAndOwnerEmail(
            String title, String email);

    Page<Expense> findAllByOwnerEmail(String email, Pageable pageable);

    Optional<Expense> findByIdAndOwnerEmail(Long id, String email);
}