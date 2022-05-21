package com.example.lab11.exceptions;

public class RelationshipAlreadyExistsException extends RuntimeException {
    public RelationshipAlreadyExistsException(String message) {
        super(message);
    }
}
