package com.example.SpringCars.services.impl;

import com.example.SpringCars.modelsDto.BrandDto;
import com.example.SpringCars.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public BrandDto add(BrandDto brand) {
        return null;
    }

    @Override
    public Optional<BrandDto> findBrandById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void deleteBrandById(UUID id) {

    }
}
