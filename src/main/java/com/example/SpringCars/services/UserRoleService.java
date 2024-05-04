package com.example.SpringCars.services;
import com.example.SpringCars.models.UserRole;
import com.example.SpringCars.models.enums.RoleEnum;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.UserRoleDto;
import com.example.SpringCars.repositories.UserRoleRepository;
import com.example.SpringCars.web.view.UserView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface UserRoleService {
    int userCount();
    List<UserRoleDto> allRoles();
    List<UserView> allUserUser();
}
