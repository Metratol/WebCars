package com.example.SpringCars.services;

import com.example.SpringCars.models.enums.RoleEnum;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleService {
    int userCount();


}
