package com.example.SpringCars.modelsDto;
import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.enums.CategoryEnum;

import java.time.LocalDateTime;
import java.util.UUID;
public class ModelDto {
    private UUID id;
    private String name;
    private CategoryEnum category;
    private String imgUrl;
    private int startYear;
    private int endYear;
    private BrandDto brand;
    public ModelDto(UUID id, String name, CategoryEnum category, String imgUrl, int startYear, int endYear, BrandDto brand) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imgUrl = imgUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }
    public ModelDto() {
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
        return "ModelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", imgUrl='" + imgUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + brand +
                '}';
    }
}
