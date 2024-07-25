package com.Budget.Application.Budget.Application.services.entriesServices;

import com.Budget.Application.Budget.Application.models.classifications.IncomeSource;
import com.Budget.Application.Budget.Application.models.dtos.IncomeDTO;
import com.Budget.Application.Budget.Application.models.entries.Income;
import com.Budget.Application.Budget.Application.repositories.entriesRepositories.IncomeRepository;
import com.Budget.Application.Budget.Application.services.classificationsServices.IncomeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    IncomeSourceService incomeSourceService;

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

    public Income addIncomeForController(IncomeDTO incomeDTO){
        IncomeSource incomeSource = incomeSourceService.getIncomeSourceById(incomeDTO.getIncomeSourceId()).get();

        Income incomeToAdd = new Income();

        incomeToAdd.setIncomeSource(incomeSource);
        incomeToAdd.setPreTaxAmount(incomeDTO.getPreTaxAmount());
        incomeToAdd.setPostTaxAmount(incomeDTO.getPostTaxAmount());
        incomeToAdd.setDescription(incomeDTO.getDescription());
        incomeToAdd.setEntryType(incomeDTO.getEntryType());

        incomeToAdd.setTimeOfCreation(LocalDateTime.now());

        incomeRepository.save(incomeToAdd);
        Income addedIncome = incomeRepository.findById(incomeToAdd.getId()).get();
        return addedIncome;
    }

    public Income addIncome(Income incomeToAdd){
        incomeRepository.save(incomeToAdd);
        return incomeToAdd;
    }

    public Income modifyIncome(IncomeDTO incomeDTO) {
        Income incomeToModify = incomeRepository.findById(incomeDTO.getId()).get();

        IncomeSource incomeSource = incomeSourceService.getIncomeSourceById(incomeDTO.getIncomeSourceId()).get();

        incomeToModify.setNumberOfEdits(incomeToModify.getNumberOfEdits() + 1);
        incomeToModify.setIncomeSource(incomeSource);
        incomeToModify.setPostTaxAmount(incomeDTO.getPostTaxAmount());
        incomeToModify.setPreTaxAmount(incomeDTO.getPreTaxAmount());
        incomeToModify.setDescription(incomeDTO.getDescription());
        incomeToModify.setTimeOfLastEdit(LocalDateTime.now());

        incomeRepository.save(incomeToModify);

        return incomeToModify;
    }

    public void deleteIncomeById(Long id) {
        incomeRepository.deleteById(id);
    }
}
