package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.Budget;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    BudgetRepository budgetRepository;

    public List<Integer> getBudgetYears(){
        return budgetRepository.findDistinctYears();
    }

    public List<Budget> findBudgetByMonthAndYear(int month, int year){
        return budgetRepository.findByMonthAndYear(month, year);
    }

    public List<Budget> getAllBudgets(){
        return budgetRepository.findAll();
    }

    public Budget addBudget(Budget budgetToAdd){
        budgetRepository.save(budgetToAdd);
        return budgetToAdd;
    }
}
