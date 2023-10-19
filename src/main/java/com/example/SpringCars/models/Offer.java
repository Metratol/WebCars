package com.example.SpringCars.models;


import com.example.SpringCars.models.baseModels.BaseModelIdDateUrl;
import com.example.SpringCars.models.enums.EngineEnum;
import jakarta.persistence.*;
import com.example.SpringCars.models.enums.TransmissionEnum;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;

@Entity
@Table(name ="offers")
public class Offer extends BaseModelIdDateUrl {
    @Column(name = "description")
    private String description;
    @Column(name = "engine")
    @Enumerated(EnumType.ORDINAL)
    private EngineEnum engine;

    @Column(name = "price")
    private float price;

    @Column(name = "transmission")
    private TransmissionEnum transmisson;

    @Column(name = "year")
    private int year;
    @Column(name = "mileage")
    private int milieage;

    @ManyToOne
    @JoinColumn(name = "model_id",referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Model model;


    @ManyToOne
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private User seller;

    public Offer(String description, EngineEnum engine, float price, TransmissionEnum transmisson, int year, int milieage, Model model, User seller) {
        this.description = description;
        this.engine = engine;
        this.price = price;
        this.transmisson = transmisson;
        this.year = year;
        this.milieage = milieage;
        this.model = model;
        this.seller = seller;
    }

    protected Offer() {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public TransmissionEnum getTransmisson() {
        return transmisson;
    }

    public void setTransmisson(TransmissionEnum transmisson) {
        this.transmisson = transmisson;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public int getMilieage() {
        return milieage;
    }

    public void setMilieage(int milieage) {
        this.milieage = milieage;
    }
}
