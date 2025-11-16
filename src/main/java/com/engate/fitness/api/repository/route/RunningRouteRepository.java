package com.engate.fitness.api.repository.route;

import com.engate.fitness.api.infrastructure.models.route.RunningRoute;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunningRouteRepository extends JpaRepository<RunningRoute, Long> {

    List<RunningRoute> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String name, String location);
}

