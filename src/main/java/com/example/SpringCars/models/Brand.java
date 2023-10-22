package com.example.SpringCars.models;

import com.example.SpringCars.models.baseModels.BaseModelIdDate;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name ="brands")
public class Brand extends BaseModelIdDate {
    @Column(name ="name")
    private String name;

    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Model> models;


    public Brand(String name) {
        this.name = name;
    }

    protected Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
