package com.engate.fitness.api.controller.strength.dto;

public record StrengthTrainingExerciseResponse(
        Long id,
        Integer orderIndex,
        Integer quantity,
        Integer repetitions,
        String exerciseName
) {
}

