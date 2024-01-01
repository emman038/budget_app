package com.Budget.Application.Budget.Application.repositories.entriesRepositories;

import com.Budget.Application.Budget.Application.models.entries.SavingGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SavingGoalRepository extends JpaRepository<SavingGoal, Long> {

    @Query("SELECT DISTINCT EXTRACT(YEAR FROM timeOfCreation) FROM SavingGoal")
    List<Integer> findDistinctYears();

    @Query("SELECT s FROM SavingGoal s WHERE EXTRACT(MONTH FROM s.timeOfCreation) = :month AND EXTRACT(YEAR FROM s.timeOfCreation) = :year")
    List<SavingGoal> findByMonthAndYear(int month, int year);
}
