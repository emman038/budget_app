package com.Budget.Application.Budget.Application.models.entries;

import com.Budget.Application.Budget.Application.models.EntryType;
import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "budgets")
public class Budget extends Entry{

    @Column
    private int amount;

    @ManyToOne
    @JoinColumn(name = "expense_category_id")
    @JsonIgnoreProperties({"expenses", "budgets"})
    private ExpenseCategory expenseCategory;

    public Budget(EntryType entryType, LocalDateTime timeOfCreation, ExpenseCategory expenseCategory, int amount) {
        super(entryType, timeOfCreation);
        this.expenseCategory = expenseCategory;
        this.amount = amount;
    }

    public Budget() {
    }

    public ExpenseCategory getExpenseCategory() {
        return this.expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
