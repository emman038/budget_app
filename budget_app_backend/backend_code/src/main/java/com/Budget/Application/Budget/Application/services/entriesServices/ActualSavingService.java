package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.ActualSavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ActualSaving> getActualSavingById(Long id) {
        return actualSavingRepository.findById(id);
    }

    public ActualSaving modifyActualSaving(ActualSaving actualSaving) {
        ActualSaving actualSavingToModify = actualSavingRepository.findById(actualSaving.getId()).get();

        actualSavingToModify.setNumberOfEdits(actualSavingToModify.getNumberOfEdits() + 1);
        actualSavingToModify.setSavingCategory(actualSaving.getSavingCategory());
        actualSavingToModify.setAmount(actualSaving.getAmount());
        actualSavingToModify.setDescription(actualSaving.getDescription());
        actualSavingToModify.setTimeOfLastEdit(actualSaving.getTimeOfLastEdit());

        actualSavingRepository.save(actualSavingToModify);

        return actualSavingToModify;
    }

    public void deleteActualSavingById(Long id){
        actualSavingRepository.deleteById(id);
    }
}
