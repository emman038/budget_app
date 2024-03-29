package com.Budget.Application.Budget.Application.models.dtos;

import com.Budget.Application.Budget.Application.models.EntryType;

public class BudgetExpenseDTO {

    private Long id;

    private EntryType entryType;

    private String timeOfCreation;

    private String description;

    private Long expenseCategoryId;

    private Integer amount;

    public BudgetExpenseDTO(EntryType entryType, String timeOfCreation, Long expenseCategoryId, Integer amount) {
        this.entryType = entryType;
        this.timeOfCreation = timeOfCreation;
        this.description = null;
        this.expenseCategoryId = expenseCategoryId;
        this.amount = amount;
        this.id = null;
    }

    public BudgetExpenseDTO() {
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public String getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(String timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(Long expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
