package com.challenge.hulkstore.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FranchiseNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 43876691117560211L;

    public FranchiseNotFoundException(Long id) {
        super("Unable to find Franchise ID: " + id);
    }
}
