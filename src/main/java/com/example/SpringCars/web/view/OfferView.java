package com.example.SpringCars.web.view;

import com.example.SpringCars.models.enums.EngineEnum;
import com.example.SpringCars.models.enums.TransmissionEnum;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.UserDto;

public class OfferView {
    private String id;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private int milieage;
    private int price;
    private TransmissionEnum transmission;
    private int year;
    private ModelDto model;
    private UserDto seller;

    public OfferView(String id, String description, EngineEnum engine, String imageUrl, int milieage, int price, TransmissionEnum transmission, int year, ModelDto model, UserDto seller) {
        this.id = id;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.milieage = milieage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    public OfferView() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMilieage() {
        return milieage;
    }

    public void setMilieage(int milieage) {
        this.milieage = milieage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OfferView{" +
                "description='" + description + '\'' +
                ", engine=" + engine.name() +
                ", imageUrl='" + imageUrl + '\'' +
                ", milieage=" + milieage +
                ", price=" + price +
                ", transmission=" + transmission.name() +
                ", year=" + year +
                ", model=" + model.getName() +
                ", seller=" + seller.getUsername() +
                '}';
    }
}
