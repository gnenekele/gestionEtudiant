package com.example.gestionEtudiants.exception;

import lombok.Getter;

@Getter
public class DatabaseException extends RuntimeException {
    private final String errorCode;
    private final String sqlState;

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "ERR_DB_001";
        this.sqlState = (cause instanceof java.sql.SQLException)
                ? ((java.sql.SQLException) cause).getSQLState()
                : null;
    }

    public DatabaseException(String message) {
        super(message);
        this.errorCode = "ERR_DB_001";
        this.sqlState = null;
    }
}