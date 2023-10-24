package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Model;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.repositories.ModelRepository;
import com.example.SpringCars.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    ModelMapper modelMapper;
    ModelRepository modelRepository;

    public ModelServiceImpl(ModelMapper modelMapper, ModelRepository modelRepository) {
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
    }

    @Override
    public ModelDto add(ModelDto model) {
        com.example.SpringCars.models.Model m = modelMapper.map(model, Model.class);
        return modelMapper.map(modelRepository.save(m),ModelDto.class);
    }

    @Override
    public Optional<ModelDto> findModelById(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id),ModelDto.class));
    }

    @Override
    public List<ModelDto> getAllModels() {
        return modelRepository.findAll().stream().map((m) -> modelMapper.map(m,ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updateModelName(UUID id, String newName) {
        Model model = modelRepository.findModelById(id);
        model.setName(newName);
        modelRepository.save(model);

    }

    @Override
    public void deleteModelById(UUID id) {
        modelRepository.deleteById(id);

    }
}
