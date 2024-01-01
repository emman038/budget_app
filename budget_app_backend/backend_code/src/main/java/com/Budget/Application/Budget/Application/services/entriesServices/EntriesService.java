package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.dtos.EntriesByMonthDTO;
import com.Budget.Application.Budget.Application.models.dtos.EntriesByYearDTO;
import com.Budget.Application.Budget.Application.models.entries.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class EntriesService {

    @Autowired
    IncomeService incomeService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    BudgetService budgetService;

    @Autowired
    ActualSavingService actualSavingService;

    @Autowired
    SavingGoalService savingGoalService;

    public List<EntriesByYearDTO> getEntriesByYear(){
        List<Integer> distinctYearsOfEntries = getDistinctYearsOfEntries();
        List<EntriesByYearDTO> entriesByYearDTOList = new ArrayList<>();

        for (Integer year: distinctYearsOfEntries){
            List<EntriesByMonthDTO> entriesByMonthDTOList = getEntriesForAYear(year);
            EntriesByYearDTO entriesByYearDTO = new EntriesByYearDTO(year, entriesByMonthDTOList);
            entriesByYearDTOList.add(entriesByYearDTO);
        }
        return entriesByYearDTOList;
    }

    public List<EntriesByMonthDTO> getEntriesForAYear(int year){
        List<EntriesByMonthDTO> entriesByMonthDTOList = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            EntriesByMonthDTO entriesByMonthDTO = new EntriesByMonthDTO(month,
                    incomeService.findIncomeByMonthAndYear(month, year),
                    expenseService.findExpenseByMonthAndYear(month, year),
                    budgetService.findBudgetByMonthAndYear(month, year),
                    actualSavingService.findActualSavingByMonthAndYear(month, year),
                    savingGoalService.findSavingGoalByMonthAndYear(month, year));

            entriesByMonthDTOList.add(entriesByMonthDTO);
        }
        return entriesByMonthDTOList;
    }

    public List<Integer> getDistinctYearsOfEntries() {
        List<Integer> incomeEntriesYears = incomeService.getIncomeYears();
        List<Integer> expenseEntriesYears = expenseService.getExpenseYears();
        List<Integer> budgetEntriesYears = budgetService.getBudgetYears();
        List<Integer> actualSavingEntriesYears = actualSavingService.getActualSavingYears();
        List<Integer> savingGoalEntriesYears = savingGoalService.getSavingGoalYears();

        List<Integer> filteredEntriesYears = Stream.of(
                        incomeEntriesYears,
                        expenseEntriesYears,
                        budgetEntriesYears,
                        actualSavingEntriesYears,
                        savingGoalEntriesYears
                )
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        return filteredEntriesYears;
    }

}
