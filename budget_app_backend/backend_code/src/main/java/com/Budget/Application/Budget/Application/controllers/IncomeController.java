package com.Budget.Application.Budget.Application.controllers;

import com.Budget.Application.Budget.Application.models.entries.Income;
import com.Budget.Application.Budget.Application.services.entriesServices.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes(){
        return new ResponseEntity<>(incomeService.getAllIncomes(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id){
        Optional<Income> optionalIncome = incomeService.getIncomeById(id);

        if (optionalIncome.isPresent()){
            return new ResponseEntity<>(optionalIncome.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody Income income){
        return new ResponseEntity<>(incomeService.addIncome(income), HttpStatus.OK);
    }
}
