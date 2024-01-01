package com.Budget.Application.Budget.Application.repositories.entriesRepositories;

import com.Budget.Application.Budget.Application.models.entries.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    @Query("SELECT DISTINCT EXTRACT(YEAR FROM timeOfCreation) FROM Budget")
    List<Integer> findDistinctYears();

    @Query("SELECT b FROM Budget b WHERE EXTRACT(MONTH FROM b.timeOfCreation) = :month AND EXTRACT(YEAR FROM b.timeOfCreation) = :year")
    List<Budget> findByMonthAndYear(int month, int year);
}
