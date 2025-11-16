package com.engate.fitness.api.repository.strength;

import com.engate.fitness.api.infrastructure.models.strength.StrengthTraining;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrengthTrainingRepository extends JpaRepository<StrengthTraining, Long> {
}

