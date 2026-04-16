package com.example.gestionEtudiants.exception;

import lombok.Getter;

@Getter
public class DuplicateResourceException extends RuntimeException {
    private final String errorCode;

    public DuplicateResourceException(String resource, String field) {
        super(String.format("%s existe déjà avec ce %s", resource, field));
        this.errorCode = "ERR_409";
    }
}