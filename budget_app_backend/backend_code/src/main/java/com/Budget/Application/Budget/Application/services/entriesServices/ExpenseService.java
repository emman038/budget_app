package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.Expense;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Expense addExpense(Expense expenseToAdd){
        expenseRepository.save(expenseToAdd);
        return expenseToAdd;
    }
}
