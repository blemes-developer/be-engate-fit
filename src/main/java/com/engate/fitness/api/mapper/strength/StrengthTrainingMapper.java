package com.engate.fitness.api.mapper.strength;

import com.engate.fitness.api.controller.strength.dto.StrengthTrainingExerciseRequest;
import com.engate.fitness.api.controller.strength.dto.StrengthTrainingExerciseResponse;
import com.engate.fitness.api.controller.strength.dto.StrengthTrainingRequest;
import com.engate.fitness.api.controller.strength.dto.StrengthTrainingResponse;
import com.engate.fitness.api.infrastructure.models.strength.StrengthTraining;
import com.engate.fitness.api.infrastructure.models.strength.StrengthTrainingExercise;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StrengthTrainingMapper {

    public StrengthTraining toEntity(StrengthTrainingRequest request) {
        if (request == null) {
            return null;
        }
        StrengthTraining training = new StrengthTraining(
                request.name(),
                request.location()
        );

        if (request.exercises() != null) {
            List<StrengthTrainingExercise> exercises = new ArrayList<>();
            int index = 0;
            for (StrengthTrainingExerciseRequest exReq : request.exercises()) {
                StrengthTrainingExercise exercise = new StrengthTrainingExercise(
                        exReq.orderIndex() != null ? exReq.orderIndex() : index,
                        exReq.quantity(),
                        exReq.repetitions(),
                        exReq.exerciseName()
                );
                exercise.setTraining(training);
                exercises.add(exercise);
                index++;
            }
            training.setExercises(exercises);
        }

        return training;
    }

    public StrengthTrainingResponse toResponse(StrengthTraining entity) {
        if (entity == null) {
            return null;
        }

        List<StrengthTrainingExerciseResponse> exerciseResponses = entity.getExercises()
                .stream()
                .sorted(Comparator.comparing(StrengthTrainingExercise::getOrderIndex))
                .map(exercise -> new StrengthTrainingExerciseResponse(
                        exercise.getId(),
                        exercise.getOrderIndex(),
                        exercise.getQuantity(),
                        exercise.getRepetitions(),
                        exercise.getExerciseName()
                ))
                .toList();

        return new StrengthTrainingResponse(
                entity.getId(),
                entity.getName(),
                entity.getLocation(),
                exerciseResponses
        );
    }
}

