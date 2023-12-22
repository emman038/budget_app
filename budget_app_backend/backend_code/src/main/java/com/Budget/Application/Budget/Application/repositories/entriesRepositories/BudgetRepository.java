package com.Budget.Application.Budget.Application.repositories.entriesRepositories;

import com.Budget.Application.Budget.Application.models.entries.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
