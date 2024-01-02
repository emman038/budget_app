package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.Budget;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Budget> getBudgetById(Long id){
        return budgetRepository.findById(id);
    }

    public Budget addBudget(Budget budgetToAdd){
        budgetRepository.save(budgetToAdd);
        return budgetToAdd;
    }

    public Budget modifyBudget(Budget budget) {
        Budget budgetToModify = budgetRepository.findById(budget.getId()).get();

        budgetToModify.setNumberOfEdits(budgetToModify.getNumberOfEdits() + 1);
        budgetToModify.setExpenseCategory(budget.getExpenseCategory());
        budgetToModify.setAmount(budget.getAmount());
        budgetToModify.setDescription(budget.getDescription());
        budgetToModify.setTimeOfLastEdit(budget.getTimeOfLastEdit());

        budgetRepository.save(budgetToModify);

        return budgetToModify;
    }

    public void deleteBudgetById(Long id){
        budgetRepository.deleteById(id);
    }
}
