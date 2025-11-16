package com.engate.fitness.api.controller.strength;

import com.engate.fitness.api.controller.strength.dto.StrengthTrainingRequest;
import com.engate.fitness.api.controller.strength.dto.StrengthTrainingResponse;
import com.engate.fitness.api.infrastructure.models.strength.StrengthTraining;
import com.engate.fitness.api.mapper.strength.StrengthTrainingMapper;
import com.engate.fitness.api.service.strength.StrengthTrainingService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/strength-trainings")
public class StrengthTrainingController {

    private final StrengthTrainingService service;
    private final StrengthTrainingMapper mapper;

    public StrengthTrainingController(StrengthTrainingService service, StrengthTrainingMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<StrengthTrainingResponse> list() {
        List<StrengthTraining> trainings = service.findAll();
        return trainings.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public StrengthTrainingResponse get(@PathVariable Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StrengthTrainingResponse create(@RequestBody StrengthTrainingRequest request) {
        StrengthTraining training = mapper.toEntity(request);
        return mapper.toResponse(service.create(training));
    }

    @PutMapping("/{id}")
    public StrengthTrainingResponse update(@PathVariable Long id, @RequestBody StrengthTrainingRequest request) {
        StrengthTraining training = mapper.toEntity(request);
        return mapper.toResponse(service.update(id, training));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

