package com.example.SpringCars.services;

import com.example.SpringCars.models.Offer;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.OfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {
 OfferDto add(OfferDto offer);
 Optional<OfferDto> findOfferById(UUID id);
 void updateOfferPrice(UUID id,int newPrice);
 List<OfferDto> getAllOffers();
 void deleteModelById(UUID id);

 void saveAllOffers(List<Offer> offers);
}
