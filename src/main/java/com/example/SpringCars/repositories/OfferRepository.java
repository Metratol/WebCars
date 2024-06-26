package com.example.SpringCars.repositories;
import com.example.SpringCars.models.Brand;
import com.example.SpringCars.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    Offer findOfferByPrice(float price);
    List<Offer> findOfferById(UUID id);
}
