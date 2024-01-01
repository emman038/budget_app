package com.Budget.Application.Budget.Application.services.classificationsServices;

import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;
import com.Budget.Application.Budget.Application.repositories.classificationsRepositories.SavingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingCategoryService {

    @Autowired
    SavingCategoryRepository savingCategoryRepository;

    public List<SavingCategory> getAllSavingCategories(){
        return savingCategoryRepository.findAll();
    }

    public SavingCategory addSavingCategory(SavingCategory savingCategoryToAdd){
        savingCategoryRepository.save(savingCategoryToAdd);
        return savingCategoryToAdd;
    }
}
