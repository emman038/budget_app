package com.Budget.Application.Budget.Application.models.dtos;

import com.Budget.Application.Budget.Application.models.EntryType;

public class SavingsDTO {

    private EntryType entryType;

    private String timeOfCreation;

    private String description;

    private Long savingCategoryId;

    private Integer amount;

    public SavingsDTO(EntryType entryType, String timeOfCreation, Long savingCategoryId, Integer amount) {
        this.entryType = entryType;
        this.timeOfCreation = timeOfCreation;
        this.savingCategoryId = savingCategoryId;
        this.amount = amount;
        this.description = null;
    }

    public SavingsDTO() {
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

    public Long getSavingCategoryId() {
        return savingCategoryId;
    }

    public void setSavingCategoryId(Long savingCategoryId) {
        this.savingCategoryId = savingCategoryId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
