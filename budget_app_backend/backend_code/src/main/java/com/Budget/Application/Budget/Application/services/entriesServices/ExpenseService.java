package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.models.dtos.BudgetExpenseDTO;
import com.Budget.Application.Budget.Application.models.entries.Expense;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.ExpenseRepository;
import com.Budget.Application.Budget.Application.services.classificationsServices.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    ExpenseCategoryService expenseCategoryService;

    public List<Integer> getExpenseYears(){
        return expenseRepository.findDistinctYears();
    }

    public List<Expense> findExpenseByMonthAndYear(int month, int year){
        return expenseRepository.findByMonthAndYear(month, year);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id){
        return expenseRepository.findById(id);
    }

    public Expense addExpenseForController(BudgetExpenseDTO expenseDTO) {
        ExpenseCategory expenseCategory = expenseCategoryService.getExpenseCategoryById(expenseDTO.getExpenseCategoryId()).get();

        Expense expenseToAdd = new Expense();

        expenseToAdd.setExpenseCategory(expenseCategory);
        expenseToAdd.setAmount(expenseDTO.getAmount());
        expenseToAdd.setDescription(expenseDTO.getDescription());
        expenseToAdd.setEntryType(expenseDTO.getEntryType());

        expenseToAdd.setTimeOfCreation(LocalDateTime.now());

        expenseRepository.save(expenseToAdd);
        Expense addedExpense = expenseRepository.findById(expenseToAdd.getId()).get();
        return addedExpense;
    }

    public Expense addExpense(Expense expenseToAdd){
        expenseRepository.save(expenseToAdd);
        return expenseToAdd;
    }

    public Expense modifyExpense(BudgetExpenseDTO expenseDTO) {
        Expense expenseToModify = expenseRepository.findById(expenseDTO.getId()).get();

        ExpenseCategory expenseCategory = expenseCategoryService.getExpenseCategoryById(expenseDTO.getExpenseCategoryId()).get();

        expenseToModify.setNumberOfEdits(expenseToModify.getNumberOfEdits() + 1);
        expenseToModify.setExpenseCategory(expenseCategory);
        expenseToModify.setAmount(expenseDTO.getAmount());
        expenseToModify.setDescription(expenseDTO.getDescription());
        expenseToModify.setTimeOfLastEdit(LocalDateTime.now());

        expenseRepository.save(expenseToModify);

        return expenseToModify;
    }

    public void deleteExpenseById(Long id){
        expenseRepository.deleteById(id);
    }
}
