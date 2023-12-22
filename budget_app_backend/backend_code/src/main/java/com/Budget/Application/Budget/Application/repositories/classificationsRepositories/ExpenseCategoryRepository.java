package com.Budget.Application.Budget.Application.repositories.classificationsRepositories;

import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long>{
}
