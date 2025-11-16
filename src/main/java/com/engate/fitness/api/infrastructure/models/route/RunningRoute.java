package com.engate.fitness.api.infrastructure.models.route;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "running_routes")
@Getter
@Setter
public class RunningRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private boolean favorite;

    protected RunningRoute() {
    }

    public RunningRoute(String name, String location, String description, boolean favorite) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.favorite = favorite;
    }
}

