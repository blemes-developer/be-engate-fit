package com.engate.fitness.api.exception.route;

public class RunningRouteNotFoundException extends RuntimeException {

    public RunningRouteNotFoundException(Long id) {
        super("Running route not found with id: " + id);
    }
}

