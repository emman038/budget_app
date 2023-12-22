package com.Budget.Application.Budget.Application.repositories;

import com.Budget.Application.Budget.Application.models.entries.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
