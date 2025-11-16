package com.engate.fitness.api.controller.strength.dto;

public record StrengthTrainingExerciseRequest(
        Integer orderIndex,
        Integer quantity,
        Integer repetitions,
        String exerciseName
) {
}

