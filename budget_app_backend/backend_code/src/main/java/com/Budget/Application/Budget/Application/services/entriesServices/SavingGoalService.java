package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.SavingGoal;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingGoalService {

    @Autowired
    SavingGoalRepository savingGoalRepository;

    public List<Integer> getSavingGoalYears(){
        return savingGoalRepository.findDistinctYears();
    }

    public List<SavingGoal> findSavingGoalByMonthAndYear(int month, int year){
        return savingGoalRepository.findByMonthAndYear(month, year);
    }

    public List<SavingGoal> getAllSavingGoals(){
        return savingGoalRepository.findAll();
    }

    public SavingGoal addSavingGoal(SavingGoal savingGoalToAdd){
        savingGoalRepository.save(savingGoalToAdd);
        return savingGoalToAdd;
    }

    public Optional<SavingGoal> getSavingGoalById(Long id) {
        return savingGoalRepository.findById(id);
    }

    public SavingGoal modifySavingGoal(SavingGoal savingGoal) {
        SavingGoal savingGoalToModify = savingGoalRepository.findById(savingGoal.getId()).get();

        savingGoalToModify.setNumberOfEdits(savingGoalToModify.getNumberOfEdits() + 1);
        savingGoalToModify.setSavingCategory(savingGoal.getSavingCategory());
        savingGoalToModify.setAmount(savingGoal.getAmount());
        savingGoalToModify.setDescription(savingGoal.getDescription());
        savingGoalToModify.setTimeOfLastEdit(savingGoal.getTimeOfLastEdit());

        savingGoalRepository.save(savingGoalToModify);

        return savingGoalToModify;
    }

    public void deleteSavingGoalsById(Long id){
        savingGoalRepository.deleteById(id);
    }
}
