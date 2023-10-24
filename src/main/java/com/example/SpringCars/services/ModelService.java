package com.example.SpringCars.services;

import com.example.SpringCars.models.Model;
import com.example.SpringCars.modelsDto.BrandDto;
import com.example.SpringCars.modelsDto.ModelDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService {
    ModelDto add(ModelDto model);
    Optional<ModelDto> findModelById(UUID id);
    List<ModelDto> getAllModels();
    void updateModelName(UUID id,String newName);
    void deleteModelById(UUID id);






}
