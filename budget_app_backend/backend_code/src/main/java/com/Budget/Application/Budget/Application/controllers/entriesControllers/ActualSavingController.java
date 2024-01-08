package com.Budget.Application.Budget.Application.controllers.entriesControllers;

import com.Budget.Application.Budget.Application.models.dtos.SavingsDTO;
import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import com.Budget.Application.Budget.Application.services.entriesServices.ActualSavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/actual-savings")
public class ActualSavingController {

    @Autowired
    ActualSavingService actualSavingService;

    @GetMapping
    public ResponseEntity<List<ActualSaving>> getAllActualSavings(){
        return new ResponseEntity<>(actualSavingService.getAllActualSavings(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActualSaving> getActualSavingById(@PathVariable Long id){
        Optional<ActualSaving> optionalActualSaving = actualSavingService.getActualSavingById(id);

        if (optionalActualSaving.isPresent()){
            return new ResponseEntity<>(optionalActualSaving.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ActualSaving> addActualSaving(@RequestBody SavingsDTO actualSavingDTO){
        return new ResponseEntity<>(actualSavingService.addActualSavingForController(actualSavingDTO), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<ActualSaving> modifyActualSaving(ActualSaving actualSaving){
        Optional<ActualSaving> optionalActualSaving = actualSavingService.getActualSavingById(actualSaving.getId());

        if (optionalActualSaving.isPresent()){
            return new ResponseEntity<>(actualSavingService.modifyActualSaving(actualSaving), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteActualSavingById(@PathVariable Long id){
        Optional<ActualSaving> optionalActualSaving = actualSavingService.getActualSavingById(id);

        if (optionalActualSaving.isPresent()){
            actualSavingService.deleteActualSavingById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
