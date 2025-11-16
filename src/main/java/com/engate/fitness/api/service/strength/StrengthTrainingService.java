package com.engate.fitness.api.service.strength;

import com.engate.fitness.api.exception.strength.StrengthTrainingNotFoundException;
import com.engate.fitness.api.infrastructure.models.strength.StrengthTraining;
import com.engate.fitness.api.infrastructure.models.strength.StrengthTrainingExercise;
import com.engate.fitness.api.repository.strength.StrengthTrainingRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StrengthTrainingService {

    private final StrengthTrainingRepository repository;

    public StrengthTrainingService(StrengthTrainingRepository repository) {
        this.repository = repository;
    }

    public List<StrengthTraining> findAll() {
        return repository.findAll();
    }

    public StrengthTraining getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StrengthTrainingNotFoundException(id));
    }

    public StrengthTraining create(StrengthTraining training) {
        attachTrainingToExercises(training);
        return repository.save(training);
    }

    public StrengthTraining update(Long id, StrengthTraining updated) {
        StrengthTraining current = getById(id);
        current.setName(updated.getName());
        current.setLocation(updated.getLocation());

        current.getExercises().clear();
        if (updated.getExercises() != null) {
            List<StrengthTrainingExercise> exercises = new ArrayList<>(updated.getExercises());
            for (StrengthTrainingExercise exercise : exercises) {
                exercise.setTraining(current);
                current.getExercises().add(exercise);
            }
        }

        return repository.save(current);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new StrengthTrainingNotFoundException(id);
        }
        repository.deleteById(id);
    }

    private void attachTrainingToExercises(StrengthTraining training) {
        if (training.getExercises() == null) {
            return;
        }
        for (StrengthTrainingExercise exercise : training.getExercises()) {
            exercise.setTraining(training);
        }
    }
}

