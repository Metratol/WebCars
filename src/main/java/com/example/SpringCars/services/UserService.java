package com.example.SpringCars.services;

import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDto add(UserDto user);
    Optional<UserDto> findUserById(UUID id);
    void updateUserNickname(UUID id,String newName);
    void deleteUserById(UUID id);

}
