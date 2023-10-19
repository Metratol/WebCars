package com.example.SpringCars.modelsDto;

import com.example.SpringCars.models.enums.RoleEnum;

import java.util.UUID;

public class UserRoleDto {
    private UUID id;
    private RoleEnum role;

    public UserRoleDto(UUID id, RoleEnum role) {
        this.id = id;
        this.role = role;
    }

    public UserRoleDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
