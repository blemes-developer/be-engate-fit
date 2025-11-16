package com.engate.fitness.api.exception.core;

import com.engate.fitness.api.exception.route.RunningRouteNotFoundException;
import com.engate.fitness.api.exception.strength.StrengthTrainingNotFoundException;
import com.engate.fitness.api.exception.training.TrainingPostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RunningRouteNotFoundException.class)
    public ResponseEntity<String> handleRunningRouteNotFound(RunningRouteNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TrainingPostNotFoundException.class)
    public ResponseEntity<String> handleTrainingPostNotFound(TrainingPostNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(StrengthTrainingNotFoundException.class)
    public ResponseEntity<String> handleStrengthTrainingNotFound(StrengthTrainingNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
