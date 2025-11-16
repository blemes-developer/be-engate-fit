package com.engate.fitness.api.infrastructure.models.strength;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "strength_training_exercises")
@Getter
@Setter
public class StrengthTrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer repetitions;

    @Column(nullable = false)
    private String exerciseName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", nullable = false)
    private StrengthTraining training;

    protected StrengthTrainingExercise() {
    }

    public StrengthTrainingExercise(Integer orderIndex, Integer quantity, Integer repetitions, String exerciseName) {
        this.orderIndex = orderIndex;
        this.quantity = quantity;
        this.repetitions = repetitions;
        this.exerciseName = exerciseName;
    }
}

