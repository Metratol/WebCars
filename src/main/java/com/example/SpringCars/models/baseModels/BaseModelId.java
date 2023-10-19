package com.example.SpringCars.models.baseModels;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseModelId {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
