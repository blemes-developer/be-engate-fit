package com.engate.fitness.api.service.training;

import com.engate.fitness.api.exception.training.TrainingPostNotFoundException;
import com.engate.fitness.api.infrastructure.models.training.TrainingPost;
import com.engate.fitness.api.repository.training.TrainingPostRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainingPostService {

    private final TrainingPostRepository repository;

    public TrainingPostService(TrainingPostRepository repository) {
        this.repository = repository;
    }

    public List<TrainingPost> findAll() {
        return repository.findAll();
    }

    public List<TrainingPost> searchByUser(String userName) {
        if (userName == null || userName.isBlank()) {
            return findAll();
        }
        return repository.findByUserNameContainingIgnoreCase(userName);
    }

    public TrainingPost getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TrainingPostNotFoundException(id));
    }

    public TrainingPost create(TrainingPost post) {
        return repository.save(post);
    }

    public TrainingPost update(Long id, TrainingPost updated) {
        TrainingPost current = getById(id);
        current.setUserName(updated.getUserName());
        current.setRole(updated.getRole());
        current.setDescription(updated.getDescription());
        current.setAvatarUrl(updated.getAvatarUrl());
        current.setPhotoUrls(updated.getPhotoUrls());
        return repository.save(current);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TrainingPostNotFoundException(id);
        }
        repository.deleteById(id);
    }
}

