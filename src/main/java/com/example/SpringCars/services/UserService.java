package com.example.SpringCars.services;
import com.example.SpringCars.models.User;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.web.view.OfferView;
import com.example.SpringCars.web.view.UserCreation;
import com.example.SpringCars.web.view.UserView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface UserService {
    UserView register(UserCreation user);
    Optional<UserDto> findUserById(UUID id);
    List<UserView> getAllUsers();
    void deleteUserById(UUID id);
    List<OfferView> allUserOffers(String username);
    int countOfUserOffers(String username);
    void changeUserStatus(String username);
    Optional<UserView> findUserByUsername(String username);
    public UserView createUser(UserView user);
    User getUser(String username);
    User getUserById(UUID id);
}
