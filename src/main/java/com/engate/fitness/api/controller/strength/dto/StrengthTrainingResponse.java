package com.engate.fitness.api.controller.strength.dto;

import java.util.List;

public record StrengthTrainingResponse(
        Long id,
        String name,
        String location,
        List<StrengthTrainingExerciseResponse> exercises
) {
}

