package com.example.SpringCars.web.view;

import com.example.SpringCars.models.enums.BrandEnum;
import com.example.SpringCars.models.enums.CategoryEnum;
import com.example.SpringCars.modelsDto.BrandDto;
import com.example.SpringCars.services.BrandService;
import com.example.SpringCars.services.ModelService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ModelView {
    private String id;
    BrandService brandService;
    private String name;
    private CategoryEnum category;

    private String imageUrl;
    private int startYear;

    private BrandDto brand;

    public ModelView(String id, BrandService brandService, String name, CategoryEnum category, String imageUrl, int startYear, BrandDto brand) {
        this.id = id;
        this.brandService = brandService;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.brand = brand;
    }

    public ModelView() {
    }
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @NotEmpty(message = "Название не может быть пустым")
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


    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BrandService getBrandService() {
        return brandService;
    }
}

