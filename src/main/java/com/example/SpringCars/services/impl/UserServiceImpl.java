package com.example.SpringCars.services.impl;

import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto add(UserDto user) {
        return null;
    }

    @Override
    public Optional<UserDto> findUserById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void updateUserNickname(UUID id, String newName) {

    }

    @Override
    public void deleteUserById(UUID id) {

    }
}
