package com.challenge.hulkstore.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductOutOfStockException extends RuntimeException {

    public ProductOutOfStockException(Long id) {
        super("Insufficient stock for product ID: " + id);
    }
}
