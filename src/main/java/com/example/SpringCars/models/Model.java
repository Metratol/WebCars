package com.example.SpringCars.models;
import com.example.SpringCars.models.baseModels.BaseModelIdDateUrl;
import com.example.SpringCars.models.enums.CategoryEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "models")
public class Model extends BaseModelIdDateUrl {
    @Column(name = "name")
    private String name;
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CategoryEnum category;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Brand brand;
    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Offer> offers;
    public Model(String name, CategoryEnum category, int startYear, int endYear, LocalDateTime created, LocalDateTime modified, String imgUrl, Brand brand) {
        this.setImageUrl(imgUrl);
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
        setCreated(created);
        setModified(modified);
        this.brand = brand;
    }
    protected Model() {
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
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public List<Offer> getOffers() {
        return offers;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
    @Override
    public String toString() {
        return "Model{" +
                "brand=" + brand +
                "name='" + name + '\'' +
                ", category=" + category +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
