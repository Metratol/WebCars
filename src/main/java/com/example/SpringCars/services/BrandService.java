package com.example.SpringCars.services;

import com.example.SpringCars.modelsDto.BrandDto;

import java.util.Optional;
import java.util.UUID;

public interface BrandService {
    BrandDto add(BrandDto brand);
    Optional<BrandDto> findBrandById(UUID id);

    void deleteBrandById(UUID id);



}
