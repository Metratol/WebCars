package com.example.SpringCars.web.view;

import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class UserView {

    private String username;
    private String firstName;
    private String lastName;

    private String password;
    private boolean isActive;


    public UserView(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserView() {
    }

    public String getUsername() {
        return username;
    }


    @NotEmpty(message = "Логин не может быть пустым")

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
    @NotEmpty(message = "Password can not be null")
    @Size(min = 2, max = 10, message = "Минимальный размер пароля 5 символов")

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


}
