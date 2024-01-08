package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.models.dtos.BudgetExpenseDTO;
import com.Budget.Application.Budget.Application.models.entries.Budget;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.BudgetRepository;
import com.Budget.Application.Budget.Application.services.classificationsServices.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    ExpenseCategoryService expenseCategoryService;

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

    public Budget addBudgetForController(BudgetExpenseDTO budgetDTO) {
        ExpenseCategory expenseCategory = expenseCategoryService.getExpenseCategoryById(budgetDTO.getExpenseCategoryId()).get();

        Budget budgetToAdd = new Budget();

        budgetToAdd.setExpenseCategory(expenseCategory);
        budgetToAdd.setAmount(budgetDTO.getAmount());
        budgetToAdd.setDescription(budgetDTO.getDescription());
        budgetToAdd.setEntryType(budgetDTO.getEntryType());

        budgetToAdd.setTimeOfCreation(LocalDateTime.now());

        budgetRepository.save(budgetToAdd);
        Budget addedBudget = budgetRepository.findById(budgetToAdd.getId()).get();
        return addedBudget;
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
