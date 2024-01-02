package com.Budget.Application.Budget.Application.controllers.entriesControllers;

import com.Budget.Application.Budget.Application.models.entries.SavingGoal;
import com.Budget.Application.Budget.Application.services.entriesServices.SavingGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/saving-goals")
public class SavingGoalController {

    @Autowired
    SavingGoalService savingGoalService;

    @GetMapping
    public ResponseEntity<List<SavingGoal>> getAllSavingGoals(){
        return new ResponseEntity<>(savingGoalService.getAllSavingGoals(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SavingGoal> getSavingGoalById(@PathVariable Long id){
        Optional<SavingGoal> optionalSavingGoal = savingGoalService.getSavingGoalById(id);

        if (optionalSavingGoal.isPresent()){
            return new ResponseEntity<>(optionalSavingGoal.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<SavingGoal> modifySavingGoal(SavingGoal savingGoal){
        Optional<SavingGoal> optionalSavingGoal = savingGoalService.getSavingGoalById(savingGoal.getId());

        if (optionalSavingGoal.isPresent()){
            return new ResponseEntity<>(savingGoalService.modifySavingGoal(savingGoal), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteSavingGoalById(@PathVariable Long id){
        Optional<SavingGoal> optionalSavingGoal = savingGoalService.getSavingGoalById(id);

        if (optionalSavingGoal.isPresent()){
            savingGoalService.deleteSavingGoalsById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
