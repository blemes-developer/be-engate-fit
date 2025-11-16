package com.engate.fitness.api.service.route;

import com.engate.fitness.api.exception.route.RunningRouteNotFoundException;
import com.engate.fitness.api.infrastructure.models.route.RunningRoute;
import com.engate.fitness.api.repository.route.RunningRouteRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RunningRouteService {

    private final RunningRouteRepository repository;

    public RunningRouteService(RunningRouteRepository repository) {
        this.repository = repository;
    }

    public List<RunningRoute> findAll() {
        return repository.findAll();
    }

    public List<RunningRoute> search(String query) {
        if (query == null || query.isBlank()) {
            return findAll();
        }
        return repository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(query, query);
    }

    public RunningRoute getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RunningRouteNotFoundException(id));
    }

    public RunningRoute create(RunningRoute route) {
        return repository.save(route);
    }

    public RunningRoute update(Long id, RunningRoute updated) {
        RunningRoute current = getById(id);
        current.setName(updated.getName());
        current.setLocation(updated.getLocation());
        current.setDescription(updated.getDescription());
        current.setFavorite(updated.isFavorite());
        return repository.save(current);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RunningRouteNotFoundException(id);
        }
        repository.deleteById(id);
    }
}

