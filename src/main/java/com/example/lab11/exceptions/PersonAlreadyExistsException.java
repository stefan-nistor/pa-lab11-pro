package com.example.lab11.exceptions;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException(String message) {
        super(message);
    }
}
