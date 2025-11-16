package com.engate.fitness.api.controller.strength.dto;

import java.util.List;

public record StrengthTrainingRequest(
        String name,
        String location,
        List<StrengthTrainingExerciseRequest> exercises
) {
}

