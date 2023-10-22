package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.Offer;
import com.example.SpringCars.modelsDto.OfferDto;
import com.example.SpringCars.repositories.OfferRepository;
import com.example.SpringCars.services.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    OfferRepository offerRepository;
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public OfferDto add(OfferDto offer) {
        return null;
    }

    @Override
    public Optional<OfferDto> findOfferById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void updateOfferPrice(UUID id, int newPrice) {

    }

    @Override
    public void deleteModelById(UUID id) {

    }

    @Override
    public void saveAllOffers(List<Offer> offers) {
        offerRepository.saveAll(offers);
    }
}
