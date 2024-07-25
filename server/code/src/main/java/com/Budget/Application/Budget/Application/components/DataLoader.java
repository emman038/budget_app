package com.Budget.Application.Budget.Application.components;

import com.Budget.Application.Budget.Application.models.EntryType;
import com.Budget.Application.Budget.Application.models.classifications.Classification;
import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.models.classifications.IncomeSource;
import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;
import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import com.Budget.Application.Budget.Application.models.entries.Income;
import com.Budget.Application.Budget.Application.services.classificationsServices.ExpenseCategoryService;
import com.Budget.Application.Budget.Application.services.classificationsServices.IncomeSourceService;
import com.Budget.Application.Budget.Application.services.classificationsServices.SavingCategoryService;
import com.Budget.Application.Budget.Application.services.entriesServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

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

    @Autowired
    IncomeSourceService incomeSourceService;

    @Autowired
    SavingCategoryService savingCategoryService;

    @Autowired
    ExpenseCategoryService expenseCategoryService;

    public void run(ApplicationArguments args){

//      Classifications
        IncomeSource bnta = new IncomeSource("BNTA", "Bright Network Technology Academy");
        IncomeSource eamesConsulting = new IncomeSource("Eames Consulting", "Recruitment company");
        IncomeSource ipsos = new IncomeSource("Ipsos", "Telephone Interviewer");

        incomeSourceService.addIncomeSource(bnta);
        incomeSourceService.addIncomeSource(eamesConsulting);
        incomeSourceService.addIncomeSource(ipsos);

        SavingCategory italyHoliday = new SavingCategory("Italy Holiday", "Holiday for John's Wedding");
        SavingCategory maltaHoliday = new SavingCategory("Malta Holiday", "Holiday for DLT Malta");
        SavingCategory isa = new SavingCategory("ISA", "ISA pot for first home");

        savingCategoryService.addSavingCategory(italyHoliday);
        savingCategoryService.addSavingCategory(maltaHoliday);
        savingCategoryService.addSavingCategory(isa);

        ExpenseCategory shopping = new ExpenseCategory("Shopping", "Grocery and food shopping");
        ExpenseCategory clothes = new ExpenseCategory("Clothes", "Going out clothes and sneakers etc.");
        ExpenseCategory travel = new ExpenseCategory("Travel", "TFL, Fuel, petrol etc.");

        expenseCategoryService.addExpenseCategory(shopping);
        expenseCategoryService.addExpenseCategory(clothes);
        expenseCategoryService.addExpenseCategory(travel);


//      Income
        Income oneJan2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 1, 1, 10, 30), ipsos, 2500, 2000);
        Income twoJan2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 1, 2, 13, 10), ipsos, 2500, 2000);
        Income tenFeb2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 2, 10, 15, 45), ipsos, 2500, 2000);
        Income oneMarch2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 3, 1, 22, 10), ipsos, 2500, 2000);
        Income fifteenMarch2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 3, 15, 15, 10), ipsos, 2500, 2000);
        Income oneApril2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 4, 1, 17, 45), ipsos, 2500, 2000);
        Income threeMay2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 5, 3, 18, 12), ipsos, 2500, 2000);
        Income threeJune2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 6, 3, 18, 12), ipsos, 2500, 2000);
        Income fourJuly2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 7, 4, 20, 30), ipsos, 2500, 2000);

        incomeService.addIncome(oneJan2022);
        incomeService.addIncome(twoJan2022);
        incomeService.addIncome(tenFeb2022);
        incomeService.addIncome(oneMarch2022);
        incomeService.addIncome(fifteenMarch2022);
        incomeService.addIncome(oneApril2022);
        incomeService.addIncome(threeMay2022);
        incomeService.addIncome(threeJune2022);
        incomeService.addIncome(fourJuly2022);

        Income oneAugust2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 8, 1, 10, 30), eamesConsulting, 2500, 2000);
        Income twoSeptember2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 9, 2, 13, 10), eamesConsulting, 2500, 2000);
        Income tenSeptember2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 9, 10, 15, 45), eamesConsulting, 2500, 2000);
        Income oneOctober2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 10, 1, 22, 10), eamesConsulting, 2500, 2000);
        Income fifteenOctober2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 10, 15, 15, 10), eamesConsulting, 2500, 2000);
        Income oneNovember2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 11, 1, 17, 45), ipsos, 2500, 2000);
        Income threeNovember2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 11, 3, 18, 12), ipsos, 2500, 2000);
        Income threeDecember2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 12, 3, 18, 12), ipsos, 2500, 2000);
        Income fourDecember2022 = new Income(EntryType.INCOME, LocalDateTime.of(2022, 12, 4, 20, 30), ipsos, 2500, 2000);

        incomeService.addIncome(oneAugust2022);
        incomeService.addIncome(twoSeptember2022);
        incomeService.addIncome(tenSeptember2022);
        incomeService.addIncome(oneOctober2022);
        incomeService.addIncome(fifteenOctober2022);
        incomeService.addIncome(oneNovember2022);
        incomeService.addIncome(threeNovember2022);
        incomeService.addIncome(threeDecember2022);
        incomeService.addIncome(fourDecember2022);

        Income oneJan2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 1, 1, 10, 30), bnta, 2500, 2000);
        Income twoJan2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 1, 2, 13, 10), bnta, 2500, 2000);
        Income tenFeb2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 2, 10, 15, 45), bnta, 2500, 2000);
        Income oneMarch2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 3, 1, 22, 10), bnta, 2500, 2000);
        Income fifteenMarch2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 3, 15, 15, 10), bnta, 2500, 2000);
        Income oneApril2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 4, 1, 17, 45), bnta, 2500, 2000);
        Income threeMay2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 5, 3, 18, 12), bnta, 2500, 2000);
        Income threeJune2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 6, 3, 18, 12), eamesConsulting, 2500, 2000);
        Income fourJuly2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 7, 4, 20, 30), eamesConsulting, 2500, 2000);

        incomeService.addIncome(oneJan2023);
        incomeService.addIncome(twoJan2023);
        incomeService.addIncome(tenFeb2023);
        incomeService.addIncome(oneMarch2023);
        incomeService.addIncome(fifteenMarch2023);
        incomeService.addIncome(oneApril2023);
        incomeService.addIncome(threeMay2023);
        incomeService.addIncome(threeJune2023);
        incomeService.addIncome(fourJuly2023);

        Income oneAugust2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 8, 1, 10, 30), eamesConsulting, 2500, 2000);
        Income twoSeptember2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 9, 2, 13, 10), eamesConsulting, 2500, 2000);
        Income tenSeptember2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 9, 10, 15, 45), eamesConsulting, 2500, 2000);
        Income oneOctober2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 10, 1, 22, 10), eamesConsulting, 2500, 2000);
        Income fifteenOctober2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 10, 15, 15, 10), eamesConsulting, 2500, 2000);
        Income oneNovember2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 11, 1, 17, 45), bnta, 2500, 2000);
        Income threeNovember2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 11, 3, 18, 12), bnta, 2500, 2000);
        Income threeDecember2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 12, 3, 18, 12), bnta, 2500, 2000);
        Income fourDecember2023 = new Income(EntryType.INCOME, LocalDateTime.of(2023, 12, 4, 20, 30), bnta, 2500, 2000);

        incomeService.addIncome(oneAugust2023);
        incomeService.addIncome(twoSeptember2023);
        incomeService.addIncome(tenSeptember2023);
        incomeService.addIncome(oneOctober2023);
        incomeService.addIncome(fifteenOctober2023);
        incomeService.addIncome(oneNovember2023);
        incomeService.addIncome(threeNovember2023);
        incomeService.addIncome(threeDecember2023);
        incomeService.addIncome(fourDecember2023);


//      ActualSaving
        ActualSaving oneAugust2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 8, 1, 10, 30), italyHoliday, 2500);
        ActualSaving twoSeptember2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 9, 2, 13, 10), italyHoliday, 2000);
        ActualSaving tenSeptember2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 9, 10, 15, 45), maltaHoliday, 2000);
        ActualSaving oneOctober2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 10, 1, 22, 10), maltaHoliday, 2000);
        ActualSaving fifteenOctober2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 10, 15, 15, 10), isa, 2000);
        ActualSaving oneNovember2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 11, 1, 17, 45), isa, 2500);
        ActualSaving threeNovember2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 11, 3, 18, 12), maltaHoliday, 2000);
        ActualSaving threeDecember2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 12, 3, 18, 12), italyHoliday, 2500);
        ActualSaving fourDecember2023AS = new ActualSaving(EntryType.ACTUAL_SAVING, LocalDateTime.of(2023, 12, 4, 20, 30), isa, 2500);

        actualSavingService.addActualSaving(oneAugust2023AS);
        actualSavingService.addActualSaving(twoSeptember2023AS);
        actualSavingService.addActualSaving(tenSeptember2023AS);
        actualSavingService.addActualSaving(oneOctober2023AS);
        actualSavingService.addActualSaving(fifteenOctober2023AS);
        actualSavingService.addActualSaving(oneNovember2023AS);
        actualSavingService.addActualSaving(threeNovember2023AS);
        actualSavingService.addActualSaving(threeDecember2023AS);
        actualSavingService.addActualSaving(fourDecember2023AS);
    }
}
