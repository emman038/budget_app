package com.Budget.Application.Budget.Application.models.classifications;

import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import com.Budget.Application.Budget.Application.models.entries.SavingGoal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "saving_categories")
public class SavingCategory extends Classification{

    @OneToMany(mappedBy = "savingCategory")
    @JsonIgnoreProperties({"savingCategory"})
    private List<ActualSaving> actualSavings;

    @OneToMany(mappedBy = "savingCategory")
    @JsonIgnoreProperties({"savingCategory"})
    private List<SavingGoal> savingGoals;

    public SavingCategory(String name, String description, List<ActualSaving> actualSavings, List<SavingGoal> savingGoals) {
        super(name, description);
        this.actualSavings = actualSavings;
        this.savingGoals = savingGoals;
    }

    public SavingCategory() {
    }

    public List<ActualSaving> getActualSavings() {
        return this.actualSavings;
    }

    public void setActualSavings(List<ActualSaving> actualSavings) {
        this.actualSavings = actualSavings;
    }

    public List<SavingGoal> getSavingGoals() {
        return this.savingGoals;
    }

    public void setSavingGoals(List<SavingGoal> savingGoals) {
        this.savingGoals = savingGoals;
    }
}
