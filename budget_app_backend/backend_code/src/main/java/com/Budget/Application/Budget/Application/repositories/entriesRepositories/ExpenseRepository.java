package com.Budget.Application.Budget.Application.repositories.entriesRepositories;

import com.Budget.Application.Budget.Application.models.entries.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT DISTINCT EXTRACT(YEAR FROM timeOfCreation) FROM Expense")
    List<Integer> findDistinctYears();

    @Query("SELECT e FROM Expense e WHERE EXTRACT(MONTH FROM e.timeOfCreation) = :month AND EXTRACT(YEAR FROM e.timeOfCreation) = :year")
    List<Expense> findByMonthAndYear(int month, int year);
}
