package com.example.gestionEtudiants.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;           // Code HTTP
    private String error;         // Type d'erreur
    private String message;       // Message utilisateur
    private String path;          // URL appelée
    private String errorCode;     // Code métier (ERR_xxx)
    private Map<String, Object> data;  // Données supplémentaires (compatible avec ton format)

    // Constructeur pour compatibilité avec ton ancien format Map
    public static Map<String, Object> toLegacyFormat(int code, String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        if (data != null) {
            response.put("data", data);
        }
        return response;
    }
}
