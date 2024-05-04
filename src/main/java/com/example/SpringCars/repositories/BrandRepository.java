package com.example.SpringCars.repositories;
import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Model;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.enums.BrandEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Query(value = "SELECT m FROM Model m " +
            "JOIN Brand b ON b = m.brand " +
            "WHERE b.name = :name")
    List<Model> findAllBrandModels(@Param(value = "name") String name);
    @Query(value = "SELECT o FROM Offer o " +
            "JOIN Model m ON m = o.model " +
            "JOIN Brand b ON b = m.brand  " +
            "WHERE b.name = :name")
    List<Offer> findAllBrandSales(@Param(value = "name") String name);
    @Query(value = "SELECT SUM(o.price) FROM Offer o " +
            "JOIN Model m ON m = o.model " +
            "JOIN Brand b ON b = m.brand " +
            "WHERE b.name = :name")
    int brandProfit(@Param(value = "name") String name);
    Brand findByName(String name);
}
