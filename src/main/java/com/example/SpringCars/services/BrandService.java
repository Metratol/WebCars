package com.example.SpringCars.services;

import com.example.SpringCars.models.Model;
import com.example.SpringCars.models.enums.BrandEnum;
import com.example.SpringCars.models.enums.RoleEnum;
import com.example.SpringCars.modelsDto.BrandDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {
    BrandDto add(BrandDto brand);
    Optional<BrandDto> findBrandById(UUID id);
    List<BrandDto> getAllBrands();

    void deleteBrandById(UUID id);
    List<Model> allBrandModels(BrandEnum brandEnum);
    int brandSales(BrandEnum brandEnum);
    int brandProfit(BrandEnum brandEnum);



}
