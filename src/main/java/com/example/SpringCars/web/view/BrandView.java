package com.example.SpringCars.web.view;

import com.example.SpringCars.models.Model;

import java.util.Set;

public class BrandView {
    private String name;
    private Set<Model> models;

    public BrandView(String name) {
        this.name = name;
    }

    public BrandView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandView{" +
                "name='" + name + '\'' +
                '}';
    }
}
