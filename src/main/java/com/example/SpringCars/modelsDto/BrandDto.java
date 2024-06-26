package com.example.SpringCars.modelsDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
public class BrandDto {
    private UUID id;
    private String name;
    public BrandDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    public BrandDto() {
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
    @Override
    public String toString() {
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
