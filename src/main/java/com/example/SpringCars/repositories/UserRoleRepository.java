package com.example.SpringCars.repositories;

import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.User;
import com.example.SpringCars.models.UserRole;
import com.example.SpringCars.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    List<UserRole> findAll();

    @Query(value = "SELECT u FROM User u " +
            "JOIN UserRole r ON r = u.role " +
            "WHERE r.name = :name")
    List<User> findAllWithCurrentRole(@Param(value = "name") RoleEnum roleEnum);


}
