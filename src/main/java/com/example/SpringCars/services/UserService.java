package com.example.SpringCars.services;

import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.User;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.OfferDto;
import com.example.SpringCars.modelsDto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDto add(UserDto user);
    Optional<UserDto> findUserById(UUID id);
    List<UserDto> getAllUsers();
    void updateUserNickname(UUID id,String newName);
    void deleteUserById(UUID id);
    List<Offer> allUserOffers(UUID id);
    int countOfUserOffers(UUID id);


}
