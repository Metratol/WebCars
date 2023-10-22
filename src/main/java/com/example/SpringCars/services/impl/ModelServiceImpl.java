package com.example.SpringCars.services.impl;

import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.services.ModelService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.UUID;

@Service
public class ModelServiceImpl implements ModelService {
    @Override
    public ModelDto add(ModelDto model) {
        return null;
    }

    @Override
    public Optional<ModelDto> findModelById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void updateBrandName(UUID id, String newName) {

    }

    @Override
    public void deleteModelById(UUID id) {

    }
}
