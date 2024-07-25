package com.Budget.Application.Budget.Application.models.dtos;

import com.Budget.Application.Budget.Application.models.EntryType;

public class IncomeDTO {

    private Long id;

    private EntryType entryType;

    private String description;

    private Long incomeSourceId;

    private Integer preTaxAmount;

    private Integer postTaxAmount;

    public IncomeDTO(EntryType entryType, Long incomeSourceId, Integer preTaxAmount, Integer postTaxAmount) {
        this.entryType = entryType;
        this.description = null;
        this.incomeSourceId = incomeSourceId;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
        this.id = null;
    }

    public IncomeDTO() {
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIncomeSourceId() {
        return incomeSourceId;
    }

    public void setIncomeSourceId(Long incomeSourceId) {
        this.incomeSourceId = incomeSourceId;
    }

    public Integer getPreTaxAmount() {
        return preTaxAmount;
    }

    public void setPreTaxAmount(Integer preTaxAmount) {
        this.preTaxAmount = preTaxAmount;
    }

    public Integer getPostTaxAmount() {
        return postTaxAmount;
    }

    public void setPostTaxAmount(Integer postTaxAmount) {
        this.postTaxAmount = postTaxAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
