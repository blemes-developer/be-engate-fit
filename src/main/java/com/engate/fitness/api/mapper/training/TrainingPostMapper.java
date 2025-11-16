package com.engate.fitness.api.mapper.training;

import com.engate.fitness.api.controller.training.dto.TrainingPostRequest;
import com.engate.fitness.api.controller.training.dto.TrainingPostResponse;
import com.engate.fitness.api.infrastructure.models.training.TrainingPost;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TrainingPostMapper {

    public TrainingPost toEntity(TrainingPostRequest request) {
        if (request == null) {
            return null;
        }
        List<String> photos = request.photoUrls() != null
                ? new ArrayList<>(request.photoUrls())
                : new ArrayList<>();

        return new TrainingPost(
                request.userName(),
                request.role(),
                request.description(),
                request.avatarUrl(),
                photos
        );
    }

    public TrainingPostResponse toResponse(TrainingPost entity) {
        if (entity == null) {
            return null;
        }
        return new TrainingPostResponse(
                entity.getId(),
                entity.getUserName(),
                entity.getRole(),
                entity.getDescription(),
                entity.getAvatarUrl(),
                entity.getPhotoUrls()
        );
    }
}

