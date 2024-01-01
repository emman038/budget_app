package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.ActualSavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualSavingService {

    @Autowired
    ActualSavingRepository actualSavingRepository;

    public List<Integer> getActualSavingYears(){
        return actualSavingRepository.findDistinctYears();
    }

    public List<ActualSaving> findActualSavingByMonthAndYear(int month, int year){
        return actualSavingRepository.findByMonthAndYear(month, year);
    }

    public List<ActualSaving> getAllActualSavings(){
        return actualSavingRepository.findAll();
    }

    public ActualSaving addActualSaving(ActualSaving actualSavingToAdd){
        actualSavingRepository.save(actualSavingToAdd);
        return actualSavingToAdd;
    }
}
