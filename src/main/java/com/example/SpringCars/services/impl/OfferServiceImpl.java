package com.example.SpringCars.services.impl;
import com.example.SpringCars.models.Model;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.User;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.OfferDto;
import com.example.SpringCars.repositories.OfferRepository;
import com.example.SpringCars.services.ModelService;
import com.example.SpringCars.services.OfferService;
import com.example.SpringCars.services.UserService;
import com.example.SpringCars.web.view.OfferCreation;
import com.example.SpringCars.web.view.OfferView;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@EnableCaching
@Service
public class OfferServiceImpl implements OfferService {
    OfferRepository offerRepository;
    ModelMapper modelMapper;
    ModelService modelService;
    UserService userService;
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelService modelService, UserService userService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.userService = userService;
    }
    @Override
    public Offer add(OfferCreation offer) {
        Offer o = modelMapper.map(offer, Offer.class);
        o.setSeller(userService.getUserById(offer.getSeller()));
        o.setModel(modelService.getModelById(offer.getModel()));
        System.out.println(o);
        return offerRepository.save(o);
    }
    @Override
    public Optional<OfferDto> findOfferById(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }
    @Override
    public void updateOfferPrice(UUID id, int newPrice) {
        Offer offer = (Offer) offerRepository.findOfferById(id);
        offer.setPrice(newPrice);
        offerRepository.save(offer);
    }
    @Cacheable(value = "offers", key = "#root.methodname")
    @Override
    public List<OfferView> getAllOffers() {
        return offerRepository.findAll().stream().map((o) -> modelMapper.map(o, OfferView.class)).collect(Collectors.toList());
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
