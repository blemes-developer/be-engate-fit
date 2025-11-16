package com.engate.fitness.api.controller.training.dto;

import java.util.List;

public record TrainingPostRequest(
        String userName,
        String role,
        String description,
        String avatarUrl,
        List<String> photoUrls
) {
}

