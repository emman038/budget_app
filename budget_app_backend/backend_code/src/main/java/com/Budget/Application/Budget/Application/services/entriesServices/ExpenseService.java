package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.Expense;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

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

    public Expense addExpense(Expense expenseToAdd){
        expenseRepository.save(expenseToAdd);
        return expenseToAdd;
    }

    public Expense modifyExpense(Expense expense) {
        Expense expenseToModify = expenseRepository.findById(expense.getId()).get();

        expenseToModify.setNumberOfEdits(expenseToModify.getNumberOfEdits() + 1);
        expenseToModify.setExpenseCategory(expense.getExpenseCategory());
        expenseToModify.setAmount(expense.getAmount());
        expenseToModify.setDescription(expense.getDescription());
        expenseToModify.setTimeOfLastEdit(expense.getTimeOfLastEdit());

        expenseRepository.save(expenseToModify);

        return expenseToModify;
    }

    public void deleteExpenseById(Long id){
        expenseRepository.deleteById(id);
    }
}
