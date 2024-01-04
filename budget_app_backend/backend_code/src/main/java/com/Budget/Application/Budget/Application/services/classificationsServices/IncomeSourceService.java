package com.Budget.Application.Budget.Application.services.classificationsServices;

import com.Budget.Application.Budget.Application.models.classifications.IncomeSource;
import com.Budget.Application.Budget.Application.repositories.classificationsRepositories.IncomeSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeSourceService {

    @Autowired
    IncomeSourceRepository incomeSourceRepository;

    public List<IncomeSource> getAllIncomeSources(){
        return incomeSourceRepository.findAll();
    }

    public Optional<IncomeSource> getIncomeSourceById(Long id){
        return incomeSourceRepository.findById(id);
    }

    public IncomeSource addIncomeSource(IncomeSource incomeSourceToAdd){
        incomeSourceRepository.save(incomeSourceToAdd);
        return incomeSourceToAdd;
    }
}
