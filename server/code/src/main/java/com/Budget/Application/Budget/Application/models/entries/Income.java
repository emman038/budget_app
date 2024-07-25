package com.Budget.Application.Budget.Application.models.entries;

import com.Budget.Application.Budget.Application.models.EntryType;
import com.Budget.Application.Budget.Application.models.classifications.Classification;
import com.Budget.Application.Budget.Application.models.classifications.IncomeSource;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incomes")
public class Income extends Entry{

    @Column
    private int preTaxAmount;

    @Column
    private int postTaxAmount;

    @ManyToOne
    @JoinColumn(name = "income_source_id")
    @JsonIgnoreProperties({"incomes"})
    private IncomeSource incomeSource;

    public Income(EntryType entryType, LocalDateTime timeOfCreation, IncomeSource incomeSource, int preTaxAmount, int postTaxAmount) {
        super(entryType, timeOfCreation);
        this.incomeSource = incomeSource;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
    }

    public Income() {}

    public IncomeSource getIncomeSource() {
        return this.incomeSource;
    }

    public void setIncomeSource(IncomeSource incomeSource) {
        this.incomeSource = incomeSource;
    }

    public int getPreTaxAmount() {
        return this.preTaxAmount;
    }

    public void setPreTaxAmount(int preTaxAmount) {
        this.preTaxAmount = preTaxAmount;
    }

    public int getPostTaxAmount() {
        return this.postTaxAmount;
    }

    public void setPostTaxAmount(int postTaxAmount) {
        this.postTaxAmount = postTaxAmount;
    }
}
