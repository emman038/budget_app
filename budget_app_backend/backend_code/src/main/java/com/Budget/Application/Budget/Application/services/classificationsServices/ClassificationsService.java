package com.Budget.Application.Budget.Application.services.classificationsServices;

import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.models.classifications.IncomeSource;
import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;
import com.Budget.Application.Budget.Application.models.dtos.ClassificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationsService {

    @Autowired
    IncomeSourceService incomeSourceService;

    @Autowired
    SavingCategoryService savingCategoryService;

    @Autowired
    ExpenseCategoryService expenseCategoryService;

    public ClassificationDTO getAllClassifications(){
        List<IncomeSource> incomeSources = incomeSourceService.getAllIncomeSources();
        List<SavingCategory> savingCategories = savingCategoryService.getAllSavingCategories();
        List<ExpenseCategory> expenseCategories = expenseCategoryService.getAllExpenseCategories();

        ClassificationDTO classificationDTO = new ClassificationDTO(incomeSources, savingCategories, expenseCategories);

        return classificationDTO;
    }
}
