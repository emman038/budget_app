package com.Budget.Application.Budget.Application.controllers.entriesControllers;

import com.Budget.Application.Budget.Application.models.dtos.BudgetExpenseDTO;
import com.Budget.Application.Budget.Application.models.entries.Budget;
import com.Budget.Application.Budget.Application.services.entriesServices.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    BudgetService budgetService;

    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudgets(){
        return new ResponseEntity<>(budgetService.getAllBudgets(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id){
        Optional<Budget> optionalBudget = budgetService.getBudgetById(id);

        if (optionalBudget.isPresent()){
            return new ResponseEntity<>(optionalBudget.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Budget> addBudget(@RequestBody BudgetExpenseDTO budgetDTO){
        return new ResponseEntity<>(budgetService.addBudgetForController(budgetDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Budget> modifyBudget(Budget budget){
        Optional<Budget> optionalBudget = budgetService.getBudgetById(budget.getId());

        if (optionalBudget.isPresent()){
            return new ResponseEntity<>(budgetService.modifyBudget(budget), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteBudgetById(@PathVariable Long id){
        Optional<Budget> optionalBudget = budgetService.getBudgetById(id);

        if (optionalBudget.isPresent()){
            budgetService.deleteBudgetById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
