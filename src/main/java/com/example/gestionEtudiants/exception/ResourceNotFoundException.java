package com.example.gestionEtudiants.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final String errorCode;
    private final String resourceName;
    private final Object identifier;

    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(String.format("%s non trouvé avec l'identifiant: %s", resourceName, identifier));
        this.errorCode = "ERR_404";
        this.resourceName = resourceName;
        this.identifier = identifier;
    }
}
