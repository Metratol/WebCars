package com.example.SpringCars.modelsDto;

import com.example.SpringCars.models.enums.RoleEnum;

import java.util.UUID;

public class UserRoleDto {
    private UUID id;
    private RoleEnum name;

    public UserRoleDto(UUID id, RoleEnum name) {
        this.id = id;
        this.name = name;
    }

    public UserRoleDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ", role=" + name;

    }
}
