package com.engate.fitness.api.exception.training;

public class TrainingPostNotFoundException extends RuntimeException {

    public TrainingPostNotFoundException(Long id) {
        super("Training post not found with id: " + id);
    }
}

