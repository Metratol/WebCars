package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Model;
import com.example.SpringCars.models.enums.BrandEnum;
import com.example.SpringCars.modelsDto.BrandDto;
import com.example.SpringCars.repositories.BrandRepository;
import com.example.SpringCars.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository;
    ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandDto add(BrandDto brand) {
        Brand b = modelMapper.map(brand,Brand.class);
        return modelMapper.map(brandRepository.save(b),BrandDto.class);
    }

    @Override
    public Optional<BrandDto> findBrandById(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id),BrandDto.class));
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map((b) -> modelMapper.map(b,BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteBrandById(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<Model> allBrandModels(BrandEnum brandEnum) {
        return brandRepository.findAllBrandModels(brandEnum.name());
    }

    @Override
    public int brandSales(BrandEnum brandEnum) {
        return brandRepository.findAllBrandSales(brandEnum.name()).size();
    }

    @Override
    public int brandProfit(BrandEnum brandEnum) {
        return brandRepository.brandProfit(brandEnum.name());  }


}
