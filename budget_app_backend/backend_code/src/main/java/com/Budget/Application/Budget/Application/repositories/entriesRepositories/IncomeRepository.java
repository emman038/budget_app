package com.Budget.Application.Budget.Application.repositories.entriesRepositories;

import com.Budget.Application.Budget.Application.models.entries.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT DISTINCT EXTRACT(YEAR FROM timeOfCreation) FROM Income")
    List<Integer> findDistinctYears();

    @Query("SELECT i FROM Income i WHERE EXTRACT(MONTH FROM i.timeOfCreation) = :month AND EXTRACT(YEAR FROM i.timeOfCreation) = :year")
    List<Income> findByMonthAndYear(int month, int year);
}
