package com.Budget.Application.Budget.Application.models.dtos;

import com.Budget.Application.Budget.Application.models.EntryType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class IncomeDTO {

    private EntryType entryType;

    private LocalDateTime timeOfCreation;

    private String description;

    private Long incomeSourceId;

    private Integer preTaxAmount;

    private Integer postTaxAmount;

    public IncomeDTO(EntryType entryType, LocalDateTime timeOfCreation, Long incomeSourceId, Integer preTaxAmount, Integer postTaxAmount) {
        this.entryType = entryType;
        this.timeOfCreation = timeOfCreation;
        this.description = null;
        this.incomeSourceId = incomeSourceId;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
    }

    public IncomeDTO() {
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(LocalDateTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
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
}
