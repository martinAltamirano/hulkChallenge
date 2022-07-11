package com.challenge.hulkstore.services;

import com.challenge.hulkstore.errors.ProductNotFoundException;
import com.challenge.hulkstore.models.Product;
import com.challenge.hulkstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }

    public Product editProduct(Product product, Long id) {
        return getProductById(id).map(p -> {
                    p.setDescription(product.getDescription());
                    return repository.save(p);
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        repository.delete(product);
    }

    public Product newProduct(Product product) {
        return repository.save(product);
    }
}
