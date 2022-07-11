package com.challenge.hulkstore.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 43876691117560211L;

    public ProductNotFoundException(Long id) {
        super("Unable to find Product ID: " + id);
    }
}
