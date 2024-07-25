package com.Budget.Application.Budget.Application.controllers.entriesControllers;

import com.Budget.Application.Budget.Application.models.EntryType;
import com.Budget.Application.Budget.Application.models.dtos.BudgetExpenseDTO;
import com.Budget.Application.Budget.Application.models.entries.Expense;
import com.Budget.Application.Budget.Application.services.entriesServices.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        Optional<Expense> optionalExpense = expenseService.getExpenseById(id);

        if (optionalExpense.isPresent()){
            return new ResponseEntity<>(optionalExpense.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody BudgetExpenseDTO expenseDTO){
        return new ResponseEntity<>(expenseService.addExpenseForController(expenseDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Expense> modifyExpense(@RequestBody BudgetExpenseDTO expenseDTO){
        Optional<Expense> optionalExpense = expenseService.getExpenseById(expenseDTO.getId());

        if (optionalExpense.isPresent() && expenseDTO.getEntryType().equals(EntryType.EXPENSE)){
            return new ResponseEntity<>(expenseService.modifyExpense(expenseDTO), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteExpenseById(@PathVariable Long id){
        Optional<Expense> optionalExpense = expenseService.getExpenseById(id);

        if (optionalExpense.isPresent() && optionalExpense.get().getEntryType().equals(EntryType.EXPENSE)){
            expenseService.deleteExpenseById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
