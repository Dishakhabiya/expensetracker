package com.example.expensetracker.repository;

import jakarta.persistence.EntityManager;
import com.example.expensetracker.model.Expense;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ExpenseRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void save(Expense expense){
        entityManager.persist(expense);
    }
    public Expense getByTitle(String title){
        TypedQuery<Expense> query = entityManager.createQuery(
                "SELECT e FROM Expense e WHERE e.title = :title", Expense.class);
        query.setParameter("title", title);

        // Using getResultStream().findFirst() is safer than getSingleResult()
        // because it returns null instead of throwing an exception if the title doesn't exist.
        return query.getResultStream().findFirst().orElse(null);

    }

    public List<Expense> getAll(){
        return entityManager.createQuery("SELECT e FROM Expense e", Expense.class)
                .getResultList();
    }



}
