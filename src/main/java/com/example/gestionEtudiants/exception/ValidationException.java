package com.example.gestionEtudiants.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class ValidationException extends RuntimeException {
    private final String errorCode;
    private final Map<String, String> validationErrors;

    public ValidationException(String message) {
        super(message);
        this.errorCode = "ERR_VALID_001";
        this.validationErrors = null;
    }

    public ValidationException(String message, Map<String, String> validationErrors) {
        super(message);
        this.errorCode = "l'annee existe deja";
        this.validationErrors = validationErrors;
    }
}