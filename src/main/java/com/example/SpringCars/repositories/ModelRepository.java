package com.example.SpringCars.repositories;

import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    Model findModelByName(String name);
    List<Model> findAll();
}
