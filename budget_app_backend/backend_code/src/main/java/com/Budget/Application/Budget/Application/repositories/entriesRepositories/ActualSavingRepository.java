package com.Budget.Application.Budget.Application.repositories.entriesRepositories;

import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActualSavingRepository extends JpaRepository<ActualSaving, Long> {
}
