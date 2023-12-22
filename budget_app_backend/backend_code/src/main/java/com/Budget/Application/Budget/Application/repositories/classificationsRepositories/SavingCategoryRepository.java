package com.Budget.Application.Budget.Application.repositories.classificationsRepositories;

import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingCategoryRepository extends JpaRepository<SavingCategory, Long> {
}
