package com.engate.fitness.api.exception.strength;

public class StrengthTrainingNotFoundException extends RuntimeException {

    public StrengthTrainingNotFoundException(Long id) {
        super("Strength training not found with id: " + id);
    }
}

