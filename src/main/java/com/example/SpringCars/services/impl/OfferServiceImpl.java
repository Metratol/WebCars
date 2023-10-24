package com.example.SpringCars.services.impl;

import com.example.SpringCars.models.Offer;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.OfferDto;
import com.example.SpringCars.repositories.OfferRepository;
import com.example.SpringCars.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    OfferRepository offerRepository;
    ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OfferDto add(OfferDto offer) {
        Offer o = modelMapper.map(offer,Offer.class);
        return modelMapper.map(offerRepository.save(o),OfferDto.class);
    }

    @Override
    public Optional<OfferDto> findOfferById(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id),OfferDto.class));
    }

    @Override
    public void updateOfferPrice(UUID id, int newPrice) {
        Offer offer = (Offer) offerRepository.findOfferById(id);
        offer.setPrice(newPrice);
        offerRepository.save(offer);


    }

    @Override
    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream().map((o) -> modelMapper.map(o, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteModelById(UUID id) {
        offerRepository.deleteById(id);

    }

    @Override
    public void saveAllOffers(List<Offer> offers) {
        offerRepository.saveAll(offers);
    }
}
