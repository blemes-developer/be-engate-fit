package com.engate.fitness.api.controller.training.dto;

import java.util.List;

public record TrainingPostResponse(
        Long id,
        String userName,
        String role,
        String description,
        String avatarUrl,
        List<String> photoUrls
) {
}

