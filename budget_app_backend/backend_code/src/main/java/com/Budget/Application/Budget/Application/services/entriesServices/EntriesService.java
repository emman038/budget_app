package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.dtos.EntriesByMonthDTO;
import com.Budget.Application.Budget.Application.models.dtos.EntriesByYearDTO;
import com.Budget.Application.Budget.Application.models.entries.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

        Comparator<EntriesByYearDTO> compareByYear  = (EntriesByYearDTO o1, EntriesByYearDTO o2) -> o1.getYear().compareTo(o2.getYear());
        Collections.sort(entriesByYearDTOList, compareByYear);

        return entriesByYearDTOList;
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

    public List<EntriesByMonthDTO> getEntriesForAYear(int year){
        List<EntriesByMonthDTO> entriesByMonthDTOList = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {

            List<Income> incomes =  incomeService.findIncomeByMonthAndYear(month, year);
            List<Expense> expenses = expenseService.findExpenseByMonthAndYear(month, year);
            List<Budget> budgets = budgetService.findBudgetByMonthAndYear(month, year);
            List<ActualSaving> actualSavings = actualSavingService.findActualSavingByMonthAndYear(month, year);
            List<SavingGoal> savingGoals = savingGoalService.findSavingGoalByMonthAndYear(month, year);

            if((incomes.size()+ expenses.size() + budgets.size() + actualSavings.size() + savingGoals.size()) > 0){
                EntriesByMonthDTO entriesByMonthDTO = new EntriesByMonthDTO(month,
                        incomes,
                        expenses,
                        budgets,
                        actualSavings,
                        savingGoals);

                entriesByMonthDTOList.add(entriesByMonthDTO);
            }
        }
        return entriesByMonthDTOList;
    }
}
