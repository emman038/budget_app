package com.Budget.Application.Budget.Application.models.classifications;

import com.Budget.Application.Budget.Application.models.entries.Budget;
import com.Budget.Application.Budget.Application.models.entries.Expense;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expense_categories")
public class ExpenseCategory extends Classification{

    @OneToMany(mappedBy = "expenseCategory")
    @JsonIgnoreProperties({"expenseCategory"})
    private List<Expense> expenses;

    @OneToMany(mappedBy = "expenseCategory")
    @JsonIgnoreProperties({"expenseCategory"})
    private List<Budget> budgets;

    public ExpenseCategory(String name, String description) {
        super(name, description);
        this.expenses = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    public ExpenseCategory() {
    }

    public List<Expense> getExpenses() {
        return this.expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Budget> getBudgets() {
        return this.budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }
}
