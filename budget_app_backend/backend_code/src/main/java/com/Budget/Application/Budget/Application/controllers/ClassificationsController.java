package com.Budget.Application.Budget.Application.controllers;

import com.Budget.Application.Budget.Application.models.dtos.ClassificationDTO;
import com.Budget.Application.Budget.Application.services.classificationsServices.ClassificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classifications")
public class ClassificationsController {

    @Autowired
    ClassificationsService classificationsService;

    @GetMapping
    public ResponseEntity<ClassificationDTO> getAllClassifications(){
        return new ResponseEntity<>(classificationsService.getAllClassifications(), HttpStatus.OK);
    }
}
