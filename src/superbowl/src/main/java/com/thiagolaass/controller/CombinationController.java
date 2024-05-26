package com.thiagolaass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagolaass.dto.CombinanationResponseDTO;
import com.thiagolaass.models.Placar;
import com.thiagolaass.services.CombinationService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CombinationController {

    @Autowired
    private CombinationService combinationService;
    
    @PostMapping("/verify")
    public ResponseEntity<?> calculatePossibleCombinations(@RequestBody @Valid Placar placar) {
        int combinations = combinationService.calculatePossibleCombinations(placar);
        return ResponseEntity.ok(new CombinanationResponseDTO(combinations));
    }
}
