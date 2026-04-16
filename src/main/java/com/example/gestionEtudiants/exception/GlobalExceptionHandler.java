package com.example.gestionEtudiants.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ===== CODE 300 : Erreur Métier =====
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusiness(BusinessException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 300);
        response.put("message", e.getMessage());
        response.put("data", null);
        return ResponseEntity.ok(response); // 200 HTTP mais code 300 métier
    }

    // ===== CODE 400 : Validation =====
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(ValidationException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 400);
        response.put("message", e.getMessage());
        response.put("data", null);

        if (e.getErrorCode() != null) {
            response.put("errors", e.getErrorCode()); // Détails des champs invalides
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // ===== CODE 404 : Non trouvé =====
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 404);
        response.put("message", e.getMessage());
        response.put("data", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // ===== CODE 409 : Doublon =====
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicate(DuplicateResourceException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 409);
        response.put("message", e.getMessage());
        response.put("data", null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    // ===== CODE 500 : Erreur Technique =====
    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<Map<String, Object>> handleTechnical(TechnicalException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 500);
        response.put("message", "Erreur technique: " + e.getMessage());
        response.put("data", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // ===== SQL EXCEPTIONS (distinguer 300 vs 500) =====
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String, Object>> handleSQL(SQLException e) {
        Map<String, Object> response = new HashMap<>();

        // MySQL Error 1062 = Doublon (code métier 300 ou 409)
        if (e.getErrorCode() == 1062 || e instanceof SQLIntegrityConstraintViolationException) {
            response.put("code", 300); // ou 409 selon ta préférence
            response.put("message", "Donnée en doublon");
            response.put("data", null);
            return ResponseEntity.ok(response);
        }

        // MySQL Error 1452 = Clé étrangère inexistante (code métier 300)
        if (e.getErrorCode() == 1452) {
            response.put("code", 300);
            response.put("message", "Référence invalide (clé étrangère)");
            response.put("data", null);
            return ResponseEntity.ok(response);
        }

        // Autres erreurs SQL = Technique (code 500)
        response.put("code", 500);
        response.put("message", "Erreur base de données: " + e.getMessage());
        response.put("data", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // ===== JSON MALFORMÉ (Code 400) =====
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleJsonError(HttpMessageNotReadableException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 400);
        response.put("message", "Format JSON invalide");
        response.put("data", null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // ===== TOUTE AUTRE ERREUR (Code 500) =====
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAll(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 500);
        response.put("message", "Erreur interne: " + e.getMessage());
        response.put("data", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}