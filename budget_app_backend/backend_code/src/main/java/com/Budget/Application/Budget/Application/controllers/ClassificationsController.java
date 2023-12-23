package com.Budget.Application.Budget.Application.controllers;

import com.Budget.Application.Budget.Application.models.classifications.Classification;
import com.Budget.Application.Budget.Application.services.classificationsServices.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/classifications")
public class ClassificationsController {

    @Autowired
    ClassificationService classificationService;

    @GetMapping
    public ResponseEntity<Map<String, List<Classification>>> getAllClassifications(){
        return new ResponseEntity<>(classificationService.getAllClassifications(), HttpStatus.OK);
    }
}
