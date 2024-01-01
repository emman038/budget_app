package com.Budget.Application.Budget.Application.controllers;

import com.Budget.Application.Budget.Application.models.dtos.EntriesByMonthDTO;
import com.Budget.Application.Budget.Application.models.dtos.EntriesByYearDTO;
import com.Budget.Application.Budget.Application.models.entries.ActualSaving;
import com.Budget.Application.Budget.Application.services.entriesServices.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/entries")
public class EntriesController {

    @Autowired
    EntriesService entriesService;

    @GetMapping
    public ResponseEntity<List<EntriesByYearDTO>> getEntriesByYear(){
        return new ResponseEntity<>(entriesService.getEntriesByYear(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EntriesByMonthDTO>> getEntriesForAYear(@RequestParam int year){
        return new ResponseEntity<>(entriesService.getEntriesForAYear(year), HttpStatus.OK);
    }

}
