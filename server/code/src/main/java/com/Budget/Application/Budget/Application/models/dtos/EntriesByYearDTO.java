package com.Budget.Application.Budget.Application.models.dtos;

import java.util.List;

public class EntriesByYearDTO {

    private Integer year;

    private List<EntriesByMonthDTO> monthsList;

    public EntriesByYearDTO(Integer year, List<EntriesByMonthDTO> monthsList) {
        this.year = year;
        this.monthsList = monthsList;
    }

    public EntriesByYearDTO() {
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<EntriesByMonthDTO> getMonthsList() {
        return monthsList;
    }

    public void setMonthsList(List<EntriesByMonthDTO> monthsList) {
        this.monthsList = monthsList;
    }
}
