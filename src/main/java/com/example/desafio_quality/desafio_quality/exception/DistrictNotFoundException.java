package com.example.desafio_quality.desafio_quality.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DistrictNotFoundException extends ResponseStatusException {

    public DistrictNotFoundException() {
        super(HttpStatus.BAD_REQUEST, "District not found");
    }
}
