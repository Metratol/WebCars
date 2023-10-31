package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.UserRole;
import com.example.SpringCars.models.enums.RoleEnum;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.modelsDto.UserRoleDto;
import com.example.SpringCars.repositories.UserRoleRepository;
import com.example.SpringCars.services.UserRoleService;
import com.example.SpringCars.services.UserService;
import com.example.SpringCars.web.view.UserView;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return userRoleRepository.findAllWithCurrentRole(RoleEnum.USER).size();

    }

    @Override
    public List<UserRoleDto> allRoles() {
        return userRoleRepository.findAll().stream().map((u) -> modelMapper.map(u, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserView> allUserUser() {
        return userRoleRepository.findAllWithCurrentRole(RoleEnum.USER).stream().map((u) -> modelMapper.map(u, UserView.class)).collect(Collectors.toList());
    }


}
