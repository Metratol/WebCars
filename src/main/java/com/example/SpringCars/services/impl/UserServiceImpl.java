package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.User;
import com.example.SpringCars.models.enums.RoleEnum;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.repositories.UserRepository;
import com.example.SpringCars.repositories.UserRoleRepository;
import com.example.SpringCars.services.UserService;
import com.example.SpringCars.validation.ValidationUtil;
import com.example.SpringCars.web.view.OfferView;
import com.example.SpringCars.web.view.UserCreation;
import com.example.SpringCars.web.view.UserView;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    ValidationUtil validationUtil;
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserView register(UserCreation user) {
            UserCreation userView = modelMapper.map(user,UserCreation.class);
            userView.setPassword(passwordEncoder.encode(userView.getPassword()));
            userView.setRole(userRoleRepository.findRoleByName(RoleEnum.USER).get());
            userView.setActive(true);
            userRepository.saveAndFlush(modelMapper.map(userView,User.class));
            return null;
        }
    @Override
    public UserView createUser(UserView user) {
        if (!this.validationUtil.isValid(user)) {
            this.validationUtil.violations(user).stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
        } else {
            User u = modelMapper.map(user, User.class);
            return modelMapper.map(userRepository.save((u)), UserView.class);
        }
        return null;
    }

    @Override
    public Optional<UserDto> findUserById(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id),UserDto.class));
    }

    @Override
    public List<UserView> getAllUsers() {
        return userRepository.findAll().stream().map((u) -> modelMapper.map(u,UserView.class)).collect(Collectors.toList());
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
    public void changeUserStatus(String username) {
        User user = userRepository.findUserByUsername(username).get();
        if(user.isActive()) {
            user.setActive(false);
        }
        else{
            user.setActive(true);
        }

        userRepository.saveAndFlush(userRepository.findUserByUsername(user.getUsername()).get());
    }

    @Override
    public Optional<UserView> findUserByUsername(String username) {
        return Optional.ofNullable(modelMapper.map(userRepository.findUserByUsername(username),UserView.class));
    }
    public User getUser(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findUserById(id);
    }


}
