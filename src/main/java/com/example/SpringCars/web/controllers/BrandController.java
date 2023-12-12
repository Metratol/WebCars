package com.example.SpringCars.web.controllers;

import com.example.SpringCars.models.enums.BrandEnum;
import com.example.SpringCars.models.enums.CategoryEnum;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.services.BrandService;
import com.example.SpringCars.services.ModelService;
import com.example.SpringCars.web.view.BrandView;
import com.example.SpringCars.web.view.ModelView;
import com.example.SpringCars.web.view.UserCreation;
import com.example.SpringCars.web.view.UserView;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BrandController {
    private BrandService brandService;
    private ModelService modelService;
    private ModelMapper modelMapper;

    public BrandController(BrandService brandService, ModelService modelService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("brand/{brand}/models")
    public String getAllBrandModels(@PathVariable String brand, Model model){
        List<ModelView> models = brandService.allBrandModels(brand);
        model.addAttribute("models", models);
        model.addAttribute("topmodels",modelService.topThreeModels(brand));
        return "all-brand-models";
    }
    @GetMapping("/{brand}/profit")
    public String getAllBrandProfit(@PathVariable String brand,Model model){
        int profit = brandService.brandProfit(BrandEnum.valueOf(brand));
        model.addAttribute("brand profit", profit);
        return "profit";
    }

    @GetMapping("brand/all")
    public String getAllBrands(Model model){
        List<BrandView> brands = brandService.getAllBrands();
        model.addAttribute("brands",brands);
        return "all-brands";
    }

    @GetMapping("/models")
    public ResponseEntity<List<ModelView>> getAllModels(@RequestParam String brand){
        List<ModelView> models = brandService.allBrandModels(brand);
        return ResponseEntity.status(HttpStatus.OK).body(models);
    }
    @GetMapping("/brand/models/add")
    public String addModel(Model model){
        model.addAttribute("brands",brandService.getAllBrands());
        model.addAttribute("categories", CategoryEnum.values());
        return "add-model";
    }

    @ModelAttribute("modelView")
    public ModelView initModel() {
        return new ModelView();
    }
    @PostMapping("/brand/models/add")
    public String addModel(@Valid ModelView modelView, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        model.addAttribute("models",modelService.getAllModels());
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("modelView",modelView);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelView",bindingResult);
            return "redirect:/brand/models/add";
        }
        ModelDto modelDto = modelMapper.map(modelView, ModelDto.class);
        System.out.println(modelDto);
        modelService.add(modelDto);
        return "redirect:/";
    }
}