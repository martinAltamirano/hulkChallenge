package com.challenge.hulkstore.controllers;

import com.challenge.hulkstore.models.Franchise;
import com.challenge.hulkstore.services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/v1")
public class FranchiseController {

    @Autowired
    FranchiseService franchiseService;

    @GetMapping("/franchise")
    public ResponseEntity<List<Franchise>> getFranchises() {
        return ResponseEntity.ok(franchiseService.getFranchises());
    }

    @GetMapping("/franchise/{id}")
    public ResponseEntity<Optional<Franchise>> getFranchiseById(@PathVariable Long id) {
        return ResponseEntity.ok(franchiseService.getFranchiseById(id));
    }

    @PutMapping("/franchise/{id}")
    public Franchise editFranchiseById(@RequestBody Franchise franchise, @PathVariable Long id) {
        return franchiseService.editFranchise(franchise, id);
    }

    @DeleteMapping("/franchise/{id}")
    public ResponseEntity<Franchise> deleteFranchiseById(@PathVariable Long id) {
        franchiseService.deleteFranchise(id);
        return ResponseEntity.noContent().build();
    }
}
