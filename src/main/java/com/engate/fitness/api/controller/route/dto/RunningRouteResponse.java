package com.engate.fitness.api.controller.route.dto;

public record RunningRouteResponse(
                                   Long id,
                                   String name,
                                   String location,
                                   String description,
                                   boolean favorite
) {
}

