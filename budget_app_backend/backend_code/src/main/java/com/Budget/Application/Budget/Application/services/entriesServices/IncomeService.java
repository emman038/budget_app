package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.entries.Income;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    public List<Integer> getIncomeYears(){
        return incomeRepository.findDistinctYears();
    }

    public List<Income> findIncomeByMonthAndYear(int month, int year){
        return incomeRepository.findByMonthAndYear(month, year);
    }

    public List<Income> getAllIncomes(){
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Long id){
        return incomeRepository.findById(id);
    }

    public Income addIncome(Income incomeToAdd){
        incomeRepository.save(incomeToAdd);
        return incomeToAdd;
    }

    public Income modifyIncome(Income income) {
        Income incomeToModify = incomeRepository.findById(income.getId()).get();

        incomeToModify.setNumberOfEdits(incomeToModify.getNumberOfEdits() + 1);
        incomeToModify.setIncomeSource(income.getIncomeSource());
        incomeToModify.setPostTaxAmount(income.getPostTaxAmount());
        incomeToModify.setPreTaxAmount(income.getPreTaxAmount());
        incomeToModify.setDescription(income.getDescription());
        incomeToModify.setTimeOfLastEdit(income.getTimeOfLastEdit());

        incomeRepository.save(incomeToModify);

        return incomeToModify;
    }

    public void deleteIncomeById(Long id) {
        incomeRepository.deleteById(id);
    }
}
