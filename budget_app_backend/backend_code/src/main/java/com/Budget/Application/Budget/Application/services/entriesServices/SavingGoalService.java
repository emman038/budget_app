package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.SavingGoal;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
