package com.engate.fitness.api.controller.route;

import com.engate.fitness.api.controller.route.dto.RunningRouteRequest;
import com.engate.fitness.api.controller.route.dto.RunningRouteResponse;
import com.engate.fitness.api.infrastructure.models.route.RunningRoute;
import com.engate.fitness.api.mapper.route.RunningRouteMapper;
import com.engate.fitness.api.service.route.RunningRouteService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/routes")
public class RunningRouteController {

    private final RunningRouteService service;
    private final RunningRouteMapper mapper;

    public RunningRouteController(RunningRouteService service, RunningRouteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<RunningRouteResponse> list(@RequestParam(value = "q", required = false) String query) {
        List<RunningRoute> routes = service.search(query);
        return routes.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public RunningRouteResponse get(@PathVariable Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RunningRouteResponse create(@RequestBody RunningRouteRequest request) {
        RunningRoute route = mapper.toEntity(request);
        return mapper.toResponse(service.create(route));
    }

    @PutMapping("/{id}")
    public RunningRouteResponse update(@PathVariable Long id, @RequestBody RunningRouteRequest request) {
        RunningRoute route = mapper.toEntity(request);
        return mapper.toResponse(service.update(id, route));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

