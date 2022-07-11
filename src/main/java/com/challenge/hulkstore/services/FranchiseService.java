package com.challenge.hulkstore.services;

import com.challenge.hulkstore.errors.FranchiseNotFoundException;
import com.challenge.hulkstore.models.Franchise;
import com.challenge.hulkstore.repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseService {

    @Autowired
    FranchiseRepository repository;

    public List<Franchise> getFranchises() {
        return repository.findAll();
    }

    public Optional<Franchise> getFranchiseById(Long id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new FranchiseNotFoundException(id)));
    }

    public Franchise editFranchise(Franchise franchise, Long id) {
        return getFranchiseById(id).map(f -> {
                    f.setDescription(franchise.getDescription());
                    return repository.save(f);
                })
                .orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    public void deleteFranchise(Long id) {
        Franchise franchise = repository.findById(id)
                        .orElseThrow(() -> new FranchiseNotFoundException(id));
        repository.delete(franchise);
    }
}
