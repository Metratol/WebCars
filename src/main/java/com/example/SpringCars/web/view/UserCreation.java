package com.example.SpringCars.web.view;

import com.example.SpringCars.modelsDto.UserRoleDto;

public class UserCreation {
    private String username;
    private String password;
    private UserRoleDto role;

    public UserCreation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCreation() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleDto getRole() {
        return role;
    }

    public void setRole(UserRoleDto role) {
        this.role = role;
    }
}
