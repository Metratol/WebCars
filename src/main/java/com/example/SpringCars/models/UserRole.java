package com.example.SpringCars.models;
import com.example.SpringCars.models.baseModels.BaseModelId;
import com.example.SpringCars.models.enums.RoleEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
@Entity
@Table(name = "roles")
public class UserRole extends BaseModelId {
    @Column(name = "name")
    private RoleEnum name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<User> users;
    public RoleEnum getName() {
        return name;
    }
    public void setName(RoleEnum name) {
        this.name = name;
    }
    public UserRole(RoleEnum name) {
        this.name = name;
    }
    public UserRole() {
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    @Override
    public String toString() {
        return name.name();
    }
}
