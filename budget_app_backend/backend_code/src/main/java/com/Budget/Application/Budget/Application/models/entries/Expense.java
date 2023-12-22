package com.Budget.Application.Budget.Application.models.entries;

import com.Budget.Application.Budget.Application.models.EntryType;
import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class Expense extends Entry{

    @ManyToOne
    @JoinColumn(name = "expense_category_id")
    @JsonIgnoreProperties({"expenses"})
    private ExpenseCategory expenseCategory;

    @Column
    private int amount;

    public Expense(EntryType entryType, LocalDateTime timeOfCreation, ExpenseCategory expenseCategory, int amount) {
        super(entryType, timeOfCreation);
        this.expenseCategory = expenseCategory;
        this.amount = amount;
    }

    public Expense() {
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}