package com.engate.fitness.api.controller.training;

import com.engate.fitness.api.controller.training.dto.TrainingPostRequest;
import com.engate.fitness.api.controller.training.dto.TrainingPostResponse;
import com.engate.fitness.api.infrastructure.models.training.TrainingPost;
import com.engate.fitness.api.mapper.training.TrainingPostMapper;
import com.engate.fitness.api.service.training.TrainingPostService;
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
@RequestMapping("/api/v1/training-posts")
public class TrainingPostController {

    private final TrainingPostService service;
    private final TrainingPostMapper mapper;

    public TrainingPostController(TrainingPostService service, TrainingPostMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TrainingPostResponse> list(@RequestParam(value = "user", required = false) String userName) {
        List<TrainingPost> posts = service.searchByUser(userName);
        return posts.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public TrainingPostResponse get(@PathVariable Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingPostResponse create(@RequestBody TrainingPostRequest request) {
        TrainingPost post = mapper.toEntity(request);
        return mapper.toResponse(service.create(post));
    }

    @PutMapping("/{id}")
    public TrainingPostResponse update(@PathVariable Long id, @RequestBody TrainingPostRequest request) {
        TrainingPost post = mapper.toEntity(request);
        return mapper.toResponse(service.update(id, post));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

