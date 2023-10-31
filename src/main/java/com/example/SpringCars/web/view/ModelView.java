package com.example.SpringCars.web.view;

import com.example.SpringCars.models.enums.CategoryEnum;
import com.example.SpringCars.modelsDto.BrandDto;

public class ModelView {
    private String name;
    private CategoryEnum category;

    private String imageUrl;
    private int startYear;
    private int endYear;
    private BrandDto brand;

    public ModelView(String name, CategoryEnum category, String imageUrl, int startYear, int endYear, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    public ModelView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ModelView{" +
                "name='" + name + '\'' +
                ", category=" + category.name() +
                ", imgUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + brand.getName() +
                '}';
    }
}
