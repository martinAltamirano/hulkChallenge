package com.challenge.hulkstore.repositories;

import com.challenge.hulkstore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
