package com.Budget.Application.Budget.Application.services.classificationsServices;

import com.Budget.Application.Budget.Application.models.classifications.Classification;
import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.models.classifications.IncomeSource;
import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassificationService {

    @Autowired
    IncomeSourceService incomeSourceService;

    @Autowired
    SavingCategoryService savingCategoryService;

    @Autowired
    ExpenseCategoryService expenseCategoryService;

    public Map<String, List<Classification>> getAllClassifications(){
        List<Classification> incomeSources = new ArrayList<>(incomeSourceService.getAllIncomeSources());
        List<Classification> savingCategories = new ArrayList<>(savingCategoryService.getAllSavingCategories());
        List<Classification> expenseCategories = new ArrayList<>(expenseCategoryService.getAllExpenseCategories());

        Map<String, List<Classification>> classifications = new HashMap<>();

        classifications.put("incomeSources", incomeSources);
        classifications.put("savingCategories", savingCategories);
        classifications.put("expensesCategories", expenseCategories);

        return classifications;

    }
}
