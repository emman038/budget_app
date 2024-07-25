package com.Budget.Application.Budget.Application.models.classifications;

import com.Budget.Application.Budget.Application.models.entries.Income;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "income_sources")
public class IncomeSource extends Classification {

    @OneToMany(mappedBy = "incomeSource")
    @JsonIgnoreProperties({"incomeSource"})
    private List<Income> incomes;

    public IncomeSource(String name, String description) {
        super(name, description);
        this.incomes = new ArrayList<>();
    }

    public IncomeSource(){
    }

    public List<Income> getIncomes() {
        return this.incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }
}
