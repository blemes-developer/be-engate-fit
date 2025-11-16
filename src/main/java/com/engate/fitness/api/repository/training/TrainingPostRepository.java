package com.engate.fitness.api.repository.training;

import com.engate.fitness.api.infrastructure.models.training.TrainingPost;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingPostRepository extends JpaRepository<TrainingPost, Long> {

    List<TrainingPost> findByUserNameContainingIgnoreCase(String userName);
}

