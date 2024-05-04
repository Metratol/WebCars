package com.example.SpringCars.web.view;
import com.example.SpringCars.models.Model;
import com.example.SpringCars.models.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;
public class OfferCreation {
    private UUID seller;
    private String description;
    private String engine;
    private int milieage;
    private int price;
    private int year;
    private UUID model;
    private String transmission;
    public OfferCreation(UUID seller, String description, String engine, int milieage, int price, int year, UUID model, String transmission) {
        this.seller = seller;
        this.description = description;
        this.engine = engine;
        this.milieage = milieage;
        this.price = price;
        this.year = year;
        this.model = model;
        this.transmission = transmission;
    }
    public OfferCreation() {
    }
    public UUID getSeller() {
        return seller;
    }
    public void setSeller(UUID seller) {
        this.seller = seller;
    }
    public UUID getModel() {
        return model;
    }
    public void setModel(UUID model) {
        this.model = model;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }
    @Min(value = 0, message = "Пробег не может быть отрицательным")
    public int getMilieage() {
        return milieage;
    }
    public void setMilieage(int mileage) {
        this.milieage = mileage;
    }
    @Min(value = 0, message = "Цена не может быть отрицательной")
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Min(value = 1950, message = "Цена не может быть отрицательной")
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getTransmission() {
        return transmission;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    @Override
    public String toString() {
        return "OfferCreation{" +
                "seller=" + seller +
                ", description='" + description + '\'' +
                ", engine='" + engine + '\'' +
                ", milieage=" + milieage +
                ", price=" + price +
                ", year=" + year +
                ", model=" + model +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}