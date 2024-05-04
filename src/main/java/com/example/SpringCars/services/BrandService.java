package com.example.SpringCars.services;
import com.example.SpringCars.models.enums.BrandEnum;
import com.example.SpringCars.modelsDto.BrandDto;
import com.example.SpringCars.web.view.BrandView;
import com.example.SpringCars.web.view.ModelView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface BrandService {
    BrandDto add(BrandDto brand);
    Optional<BrandDto> findBrandById(UUID id);
    List<BrandView> getAllBrands();
    void deleteBrandById(UUID id);
    List<ModelView> allBrandModels(String name);
    int brandSales(BrandEnum brandEnum);
    int brandProfit(BrandEnum brandEnum);
    Optional<BrandDto> findBrandByName(String name);
}
