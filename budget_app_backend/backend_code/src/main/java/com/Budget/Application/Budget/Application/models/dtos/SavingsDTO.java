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
}
