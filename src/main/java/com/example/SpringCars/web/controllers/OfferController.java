package com.example.SpringCars.web.controllers;

import com.example.SpringCars.models.enums.CategoryEnum;
import com.example.SpringCars.models.enums.EngineEnum;
import com.example.SpringCars.models.enums.TransmissionEnum;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.services.ModelService;
import com.example.SpringCars.services.OfferService;
import com.example.SpringCars.services.UserService;
import com.example.SpringCars.web.view.*;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
public class OfferController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
   OfferService offerService;
   UserService userService;
   ModelService modelService;
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }






    @GetMapping("/model/{id}/buy")
    public String addModel(@PathVariable String id,Model model,Principal principal){
        LOG.log(Level.INFO,"User " + principal.getName() + "want to buy model");
        model.addAttribute("user",userService.getUser(principal.getName()));
        model.addAttribute("model",modelService.findModelById(UUID.fromString(id)).get());
        model.addAttribute("transmissions", TransmissionEnum.values());
        model.addAttribute("engines", EngineEnum.values());
        return "buy-model";
    }

    @ModelAttribute("offer")
    public OfferCreation initModel() {
        return new OfferCreation();
    }
    @PostMapping("/model/buy")
    public String addModel(@Valid OfferCreation offerCreation, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offer",offerCreation);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerCreation",bindingResult);
            return "redirect:/brand/all";
        }
        OfferCreation newOffer = offerCreation;
        System.out.println(offerCreation);
        offerService.add(offerCreation);
        return "redirect:/profile";
    }
    @GetMapping("offer/{id}/detailInfo")
    public String detailOffer(@PathVariable String id,Model model,Principal principal){
        LOG.log(Level.INFO,"Snow detail offer info for" + principal.getName());
        model.addAttribute("offer",offerService.findOfferById(UUID.fromString(id)).get());
        return "offer-detail";
    }



}