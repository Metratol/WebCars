package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.User;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.OfferDto;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.repositories.UserRepository;
import com.example.SpringCars.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto add(UserDto user) {
        User u = modelMapper.map(user,User.class);
        return modelMapper.map(userRepository.save(u),UserDto.class);
    }

    @Override
    public Optional<UserDto> findUserById(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id),UserDto.class));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map((u) -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updateUserNickname(UUID id, String newName) {
        User user = userRepository.findUserById(id);
        user.setUsername(newName);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<Offer> allUserOffers(UUID id) {
        return userRepository.findAllUserOffers(id);
    }

    @Override
    public int countOfUserOffers(UUID id) {
        return (userRepository.findAllUserOffers(id)).size();
    }


}
