package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.classifications.ExpenseCategory;
import com.Budget.Application.Budget.Application.models.classifications.SavingCategory;
import com.Budget.Application.Budget.Application.models.dtos.BudgetExpenseDTO;
import com.Budget.Application.Budget.Application.models.dtos.SavingsDTO;
import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import com.Budget.Application.Budget.Application.models.entries.Expense;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.ActualSavingRepository;
import com.Budget.Application.Budget.Application.services.classificationsServices.SavingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActualSavingService {

    @Autowired
    ActualSavingRepository actualSavingRepository;

    @Autowired
    SavingCategoryService savingCategoryService;

    public List<Integer> getActualSavingYears(){
        return actualSavingRepository.findDistinctYears();
    }

    public List<ActualSaving> findActualSavingByMonthAndYear(int month, int year){
        return actualSavingRepository.findByMonthAndYear(month, year);
    }

    public List<ActualSaving> getAllActualSavings(){
        return actualSavingRepository.findAll();
    }

    public ActualSaving addActualSavingForController(SavingsDTO actualSavingDTO) {
        SavingCategory savingCategory = savingCategoryService.getSavingCategoryById(actualSavingDTO.getSavingCategoryId()).get();

        ActualSaving actualSavingToAdd = new ActualSaving();

        actualSavingToAdd.setSavingCategory(savingCategory);
        actualSavingToAdd.setAmount(actualSavingDTO.getAmount());
        actualSavingToAdd.setDescription(actualSavingDTO.getDescription());
        actualSavingToAdd.setEntryType(actualSavingDTO.getEntryType());

        actualSavingToAdd.setTimeOfCreation(LocalDateTime.now());

        actualSavingRepository.save(actualSavingToAdd);
        ActualSaving addedActualSaving = actualSavingRepository.findById(actualSavingToAdd.getId()).get();
        return addedActualSaving;
    }

    public ActualSaving addActualSaving(ActualSaving actualSavingToAdd){
        actualSavingRepository.save(actualSavingToAdd);
        return actualSavingToAdd;
    }

    public Optional<ActualSaving> getActualSavingById(Long id) {
        return actualSavingRepository.findById(id);
    }

    public ActualSaving modifyActualSaving(SavingsDTO actualSavingDTO) {
        ActualSaving actualSavingToModify = actualSavingRepository.findById(actualSavingDTO.getId()).get();

        SavingCategory savingCategory = savingCategoryService.getSavingCategoryById(actualSavingDTO.getSavingCategoryId()).get();

        actualSavingToModify.setNumberOfEdits(actualSavingToModify.getNumberOfEdits() + 1);
        actualSavingToModify.setSavingCategory(savingCategory);
        actualSavingToModify.setAmount(actualSavingDTO.getAmount());
        actualSavingToModify.setDescription(actualSavingDTO.getDescription());
        actualSavingToModify.setTimeOfLastEdit(LocalDateTime.now());

        actualSavingRepository.save(actualSavingToModify);

        return actualSavingToModify;
    }

    public void deleteActualSavingById(Long id){
        actualSavingRepository.deleteById(id);
    }
}
