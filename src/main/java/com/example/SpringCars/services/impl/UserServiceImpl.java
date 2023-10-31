package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.User;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.repositories.UserRepository;
import com.example.SpringCars.repositories.UserRoleRepository;
import com.example.SpringCars.services.UserService;
import com.example.SpringCars.web.view.OfferView;
import com.example.SpringCars.web.view.UserCreation;
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
    UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void register(UserCreation user) {
        User u = modelMapper.map(user,User.class);
        u.setRole(userRoleRepository.findAll().get(0));
        u.setActive(true);
        userRepository.saveAndFlush(u);
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
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<OfferView> allUserOffers(String username) {
        return userRepository.findAllUserOffers(username).stream().map((o) -> modelMapper.map(o, OfferView.class)).collect(Collectors.toList());
    }

    @Override
    public int countOfUserOffers(String username) {
        return (userRepository.findAllUserOffers(username)).size();
    }

    @Override
    public void unactiveUser(String id) {
        User user = userRepository.findUserById(UUID.fromString(id));
        user.setActive(false);
        userRepository.saveAndFlush(userRepository.findUserById(user.getId()));
    }


}
