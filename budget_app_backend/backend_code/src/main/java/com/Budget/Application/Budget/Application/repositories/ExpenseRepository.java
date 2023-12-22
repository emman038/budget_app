package com.Budget.Application.Budget.Application.repositories;

import com.Budget.Application.Budget.Application.models.entries.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
