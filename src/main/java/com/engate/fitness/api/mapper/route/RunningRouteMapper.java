package com.engate.fitness.api.mapper.route;

import com.engate.fitness.api.controller.route.dto.RunningRouteRequest;
import com.engate.fitness.api.controller.route.dto.RunningRouteResponse;
import com.engate.fitness.api.infrastructure.models.route.RunningRoute;
import org.springframework.stereotype.Component;

@Component
public class RunningRouteMapper {

    public RunningRoute toEntity(RunningRouteRequest request) {
        if (request == null) {
            return null;
        }
        boolean favorite = request.favorite() != null && request.favorite();
        return new RunningRoute(
                request.name(),
                request.location(),
                request.description(),
                favorite
        );
    }

    public RunningRouteResponse toResponse(RunningRoute entity) {
        if (entity == null) {
            return null;
        }
        return new RunningRouteResponse(
                entity.getId(),
                entity.getName(),
                entity.getLocation(),
                entity.getDescription(),
                entity.isFavorite()
        );
    }
}

