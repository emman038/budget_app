package com.Budget.Application.Budget.Application.services.classificationsServices;

import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.repositories.classificationsRepositories.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {

    @Autowired
    ExpenseCategoryRepository expenseCategoryRepository;

    public List<ExpenseCategory> getAllExpenseCategories(){
        return expenseCategoryRepository.findAll();
    }
}
