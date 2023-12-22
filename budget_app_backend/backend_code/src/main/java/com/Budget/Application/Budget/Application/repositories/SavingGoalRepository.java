package com.Budget.Application.Budget.Application.repositories;

import com.Budget.Application.Budget.Application.models.entries.SavingGoal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingGoalRepository extends JpaRepository<SavingGoal, Long> {
}
