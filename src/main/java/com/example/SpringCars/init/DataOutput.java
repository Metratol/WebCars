package com.example.SpringCars.init;

import com.example.SpringCars.models.Model;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.models.enums.BrandEnum;
import com.example.SpringCars.models.enums.EngineEnum;
import com.example.SpringCars.models.enums.TransmissionEnum;
import com.example.SpringCars.modelsDto.ModelDto;
import com.example.SpringCars.modelsDto.OfferDto;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class DataOutput implements CommandLineRunner {
    OfferService offerService;
    UserService userService;
    ModelService modelService;
    BrandService brandService;
    UserRoleService userRoleService;

    public DataOutput(OfferService offerService, UserService userService, ModelService modelService, BrandService brandService, UserRoleService userRoleService) {
        this.offerService = offerService;
        this.userService = userService;
        this.modelService = modelService;
        this.brandService = brandService;
        this.userRoleService = userRoleService;
    }

    @Override

    public void run(String... args) throws Exception {
//        UserDto user = userService.getAllUsers().get(0);
//        ModelDto model = modelService.getAllModels().get(1);
//        OfferDto newOffer = new OfferDto(UUID.fromString("7d8d22f6-719d-11ee-b962-0242ac120002"),"asgdasg", EngineEnum.DIESEL,"asfasdg",0,10000000, TransmissionEnum.AUTOMATIC,2023,null,null,model,user);
//        offerService.add(newOffer);
//        System.out.println(offerService.findOfferById(offerService.getAllOffers().get(1).getId()));
//        offerService.deleteModelById(UUID.fromString("84f31ac6-bc30-4f66-8f20-ef71befdc711"));

        System.out.println("\n\n\n\n\n\n\n\nКОЛИЧЕСТВО ПОЛЬЗОВАТЕЛЕЙ СЕРВИСА - " + userRoleService.userCount());


        System.out.println("\n\n\n\n\n\n\n\nВСЕ ЗАКАЗЫ КОНКРЕТНОГО ПОЛЬЗОВАТЕЛЯ");
        for (Offer i:userService.allUserOffers(userService.getAllUsers().get(0).getId())
             ) {
            System.out.println(i);

        }

        System.out.println("\n\n\n\n\n\n\n КОЛИЧЕСТВО  ЗАКАЗОВ ПОЛЬЗОВАТЕЛЯ - " + userService.countOfUserOffers(userService.getAllUsers().get(0).getId()));


        BrandEnum brandEnum = BrandEnum.LADA;
        System.out.println("\n\n\n\n\n\n\n\nКОЛИЧЕСТВА ПРОДАЖ БРЕНДА " + brandEnum.name() + " - " + brandService.brandSales(brandEnum));

        System.out.println("\n\n\n\n\n\n\n\nCУММА СДЕЛОК КОНКРЕТНОГО БРЕНДА " + brandEnum.name() + " - " + brandService.brandProfit(brandEnum) + "РУБ.");

        System.out.println("\n\n\n\n\n\n\n ВСЕ МОДЕЛИ БРЕНДА");
        for (Model i:brandService.allBrandModels(brandEnum))
         {
            System.out.println(i);

        }





   }

}
