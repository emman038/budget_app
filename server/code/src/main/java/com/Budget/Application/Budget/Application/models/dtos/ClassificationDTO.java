package com.Budget.Application.Budget.Application.models.dtos;

import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.models.classifications.IncomeSource;
import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;

import java.util.List;

public class ClassificationDTO {

    private List<IncomeSource> incomeSources;
    private List<SavingCategory> savingCategories;
    private List<ExpenseCategory> expenseCategories;

    public ClassificationDTO(List<IncomeSource> incomeSources, List<SavingCategory> savingCategories, List<ExpenseCategory> expenseCategories) {
        this.incomeSources = incomeSources;
        this.savingCategories = savingCategories;
        this.expenseCategories = expenseCategories;
    }

    public ClassificationDTO() {
    }

    public List<IncomeSource> getIncomeSources() {
        return incomeSources;
    }

    public void setIncomeSources(List<IncomeSource> incomeSources) {
        this.incomeSources = incomeSources;
    }

    public List<SavingCategory> getSavingCategories() {
        return savingCategories;
    }

    public void setSavingCategories(List<SavingCategory> savingCategories) {
        this.savingCategories = savingCategories;
    }

    public List<ExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }

    public void setExpenseCategories(List<ExpenseCategory> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }
}
