package com.example.SpringCars.models;

import com.example.SpringCars.models.baseModels.BaseModelIdDateUrl;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="users")
public class User extends BaseModelIdDateUrl {

    private boolean isActive;

    private String username;


    private String firstName;


    private String lastName;


    private String password;


    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id" )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private UserRole role;

    @Override
    public String toString() {
        return "User{" +
                "isActive=" + isActive +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "seller")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Offer> offers;

    public User(boolean isActive, String username, String firstName, String lastName, String password, LocalDateTime created, LocalDateTime modified,String imgUrl, UserRole role) {
        this.isActive = isActive;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        setCreated(created);
        setModified(modified);
        this.setImageUrl(imgUrl);
        this.role = role;
    }

    public User() {
    }
    @Column(name = "username",unique = true,nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name ="is_active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "password",nullable = false)
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

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
