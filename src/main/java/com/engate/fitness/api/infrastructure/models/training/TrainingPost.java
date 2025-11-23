package com.engate.fitness.api.infrastructure.models.training;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "training_posts")
@Getter
@Setter
public class TrainingPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String role;

    @Column(length = 1000)
    private String description;

    @Column
    private String avatarUrl;

    @ElementCollection
    @CollectionTable(
            name = "training_post_photos", joinColumns = @JoinColumn(name = "training_post_id")
    )
    @Column(name = "photo_url", nullable = false)
    private List<String> photoUrls = new ArrayList<>();

    protected TrainingPost() {

    }

    public TrainingPost(
            String userName,
            String role,
            String description,
            String avatarUrl,
            List<String> photoUrls
    ) {
        this.userName = userName;
        this.role = role;
        this.description = description;
        this.avatarUrl = avatarUrl;
        if (photoUrls != null) {
            this.photoUrls = new ArrayList<>(photoUrls);
        }
    }
}

