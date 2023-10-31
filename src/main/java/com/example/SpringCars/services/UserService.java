package com.example.SpringCars.services;

import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.web.view.OfferView;
import com.example.SpringCars.web.view.UserCreation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void register(UserCreation user);
    Optional<UserDto> findUserById(UUID id);
    List<UserDto> getAllUsers();

    void deleteUserById(UUID id);
    List<OfferView> allUserOffers(String username);
    int countOfUserOffers(String username);
    void unactiveUser(String id);


}
