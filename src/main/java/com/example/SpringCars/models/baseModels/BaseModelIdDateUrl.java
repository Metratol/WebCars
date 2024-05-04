package com.example.SpringCars.models.baseModels;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
public class BaseModelIdDateUrl extends BaseModelIdDate {
    @Column(name = "image_url")
    private String imageUrl;
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
