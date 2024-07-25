package com.Budget.Application.Budget.Application.repositories.entriesRepositories;

import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActualSavingRepository extends JpaRepository<ActualSaving, Long> {

    @Query("SELECT DISTINCT EXTRACT(YEAR FROM timeOfCreation) FROM ActualSaving")
    List<Integer> findDistinctYears();

    @Query("SELECT a FROM ActualSaving a WHERE EXTRACT(MONTH FROM a.timeOfCreation) = :month AND EXTRACT(YEAR FROM a.timeOfCreation) = :year")
    List<ActualSaving> findByMonthAndYear(int month, int year);
}
