package com.Budget.Application.Budget.Application.models.entries;

import com.Budget.Application.Budget.Application.models.EntryType;
import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "actual_savings")
public class ActualSaving extends Entry{

    @ManyToOne
    @JoinColumn(name = "saving_category_id")
    @JsonIgnoreProperties({"actualSavings", "savingGoals"})
    private SavingCategory savingCategory;

    @Column
    private int amount;

    public ActualSaving(EntryType entryType, LocalDateTime timeOfCreation, SavingCategory savingCategory, int amount) {
        super(entryType, timeOfCreation);
        this.savingCategory = savingCategory;
        this.amount = amount;
    }

    public ActualSaving() {
    }

    public SavingCategory getSavingCategory() {
        return this.savingCategory;
    }

    public void setSavingCategory(SavingCategory savingCategory) {
        this.savingCategory = savingCategory;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
