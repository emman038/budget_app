package com.Budget.Application.Budget.Application.models.dtos;

import com.Budget.Application.Budget.Application.models.entries.*;

import java.util.List;

public class EntriesByMonthDTO {

    private Integer month;

    private List<Income> incomes;

    private List<Expense> expenses;

    private List<Budget> budgets;

    private List<ActualSaving> actualSavings;

    private List<SavingGoal> savingGoals;

    public EntriesByMonthDTO(Integer month, List<Income> incomes, List<Expense> expenses, List<Budget> budgets, List<ActualSaving> actualSavings, List<SavingGoal> savingGoals) {
        this.month = month;
        this.incomes = incomes;
        this.expenses = expenses;
        this.budgets = budgets;
        this.actualSavings = actualSavings;
        this.savingGoals = savingGoals;
    }

    public EntriesByMonthDTO() {
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<ActualSaving> getActualSavings() {
        return actualSavings;
    }

    public void setActualSavings(List<ActualSaving> actualSavings) {
        this.actualSavings = actualSavings;
    }

    public List<SavingGoal> getSavingGoals() {
        return savingGoals;
    }

    public void setSavingGoals(List<SavingGoal> savingGoals) {
        this.savingGoals = savingGoals;
    }
}
