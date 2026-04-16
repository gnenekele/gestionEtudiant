package com.example.gestionEtudiants.exception;

import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {
    private final String errorCode;

    public TechnicalException(String message) {
        super(message);
        this.errorCode = "ERR_500";
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "ERR_500";
    }
}