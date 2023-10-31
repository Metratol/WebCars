package com.example.SpringCars.web.controllers;

import com.example.SpringCars.services.OfferService;
import com.example.SpringCars.web.view.OfferCreation;
import com.example.SpringCars.web.view.OfferView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {
   OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("")
    public @ResponseBody String getAll(Model model){
        List<OfferView> allOffers = offerService.getAllOffers();
        System.out.println("____________ALL OFFERS______________");
        allOffers.forEach(System.out::println);
        model.addAttribute("allOffers", allOffers);
        return "all-offers";
    }


    @PostMapping("/create")
    public ResponseEntity<OfferView> createOffer(@RequestBody OfferCreation offerInput){
        OfferView createdOffer = offerService.add(offerInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOffer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OfferView>> getAllInfoOffers(){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getAllOffers());
    }

}