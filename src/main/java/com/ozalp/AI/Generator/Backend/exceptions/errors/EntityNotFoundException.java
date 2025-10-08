package com.ozalp.AI.Generator.Backend.exceptions.errors;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
