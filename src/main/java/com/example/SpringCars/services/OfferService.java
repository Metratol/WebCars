package com.example.SpringCars.services;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.modelsDto.OfferDto;
import com.example.SpringCars.web.view.OfferCreation;
import com.example.SpringCars.web.view.OfferView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface OfferService {
    Offer add(OfferCreation offer);
    Optional<OfferDto> findOfferById(UUID id);
    void updateOfferPrice(UUID id, int newPrice);
    List<OfferView> getAllOffers();
    void deleteModelById(UUID id);
    void saveAllOffers(List<Offer> offers);
}
