package com.example.SpringCars.web.controllers;

import com.example.SpringCars.models.enums.BrandEnum;
import com.example.SpringCars.services.BrandService;
import com.example.SpringCars.services.ModelService;
import com.example.SpringCars.web.view.BrandView;
import com.example.SpringCars.web.view.ModelView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    private BrandService brandService;
    private ModelService modelService;

    public BrandController(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @GetMapping("/{brand}/models")
    public String getAllBrandModels(@PathVariable String brand, Model model){
        List<ModelView> models = brandService.allBrandModels(brand);
        model.addAttribute("models", models);
        return "all-brand-models";
    }
    @GetMapping("/{brand}/profit")
    public String getAllBrandProfit(@PathVariable String brand,Model model){
        int profit = brandService.brandProfit(BrandEnum.valueOf(brand));
        model.addAttribute("brand profit", profit);
        return "profit";
    }

    @GetMapping("/all")
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
}