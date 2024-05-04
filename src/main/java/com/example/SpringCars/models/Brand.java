package com.example.SpringCars.models;
import com.example.SpringCars.models.baseModels.BaseModelIdDate;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "brands")
public class Brand extends BaseModelIdDate {
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Model> models;
    public Brand(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        setCreated(created);
        setModified(modified);
    }
    protected Brand() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
