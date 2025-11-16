package com.engate.fitness.api.controller.route.dto;

public record RunningRouteRequest(
        String name,
        String location,
        String description,
        Boolean favorite
) {
}

