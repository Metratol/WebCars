package com.example.SpringCars.modelsDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isActive;
    private UserRoleDto role;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;

    protected UserDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserRoleDto getRole() {
        return role;
    }

    public void setRole(UserRoleDto role) {
        this.role = role;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public UserDto(UUID id, String username, String firstName, String lastName, String password, boolean isActive, UserRoleDto role, String imageUrl, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
        this.imageUrl = imageUrl;
        this.created = created;
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", role=" + role +
                ", imageUrl='" + imageUrl + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
