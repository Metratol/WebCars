package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.enums.RoleEnum;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.repositories.UserRoleRepository;
import com.example.SpringCars.services.UserRoleService;
import com.example.SpringCars.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    UserRoleRepository userRoleRepository;
    ModelMapper modelMapper;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public int userCount() {
        return userRoleRepository.findAllWithRoleUser(RoleEnum.USER).size();

    }
}
