package com.example.SpringCars.repositories;

import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByLastName(String name);
    User findUserById(UUID id);



    @Query(value = "SELECT o FROM Offer o " +
            "JOIN User u ON u = o.seller " +
            "WHERE u.id = :id")
    List<Offer> findAllUserOffers(@Param(value = "id") UUID id);
}
