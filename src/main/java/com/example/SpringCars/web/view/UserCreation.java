package com.example.SpringCars.web.view;

import com.example.SpringCars.models.UserRole;
import com.example.SpringCars.modelsDto.UserRoleDto;
import com.example.SpringCars.repositories.UserRepository;
import com.example.SpringCars.validation.UniqueUserLogin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class UserCreation {

//    @UniqueUserLogin
    private String username;
    private String password;
    private UserRole role;
    private boolean isActive;

    public UserCreation(String username, String password, UserRole role, boolean isActive) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    public UserCreation() {
    }



    @NotEmpty(message = "Логин не может быть пустым")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotEmpty(message = "Password can not be null")
    @Size(min = 2, max = 10, message = "Минимальный размер пароля 5 символов")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
