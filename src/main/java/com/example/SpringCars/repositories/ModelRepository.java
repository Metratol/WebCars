package com.example.SpringCars.repositories;

import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    Model findModelByName(String name);
    Model findModelById(UUID id);



    @Query(value = "SELECT m FROM Model m " +
            "JOIN Offer o ON o.model = m " +
            "JOIN Brand b ON b = m.brand " +
            "WHERE b.name = :name " +
            "GROUP BY m.id " +
            "HAVING COUNT(o) > 2 " +
            "ORDER BY COUNT(o) DESC " +
            "LIMIT 3")
    List<Model> findTopPopularModels(@Param(value = "name") String name);



}
