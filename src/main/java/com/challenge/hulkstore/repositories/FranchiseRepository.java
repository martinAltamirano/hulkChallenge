package com.challenge.hulkstore.repositories;

import com.challenge.hulkstore.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
}
