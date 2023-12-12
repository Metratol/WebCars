package com.example.SpringCars.init;


//@Component
//public class DataOutput implements CommandLineRunner {
//    OfferService offerService;
//    UserService userService;
//    ModelService modelService;
//    BrandService brandService;
//    UserRoleService userRoleService;
//
//    public DataOutput(OfferService offerService, UserService userService, ModelService modelService, BrandService brandService, UserRoleService userRoleService) {
//        this.offerService = offerService;
//        this.userService = userService;
//        this.modelService = modelService;
//        this.brandService = brandService;
//        this.userRoleService = userRoleService;
//    }
//
//    @Override
//
//    public void run(String... args) throws Exception {
////        UserCreation userCreation = new UserCreation("pisi","popa");
////        userService.register(userCreation);
////
////        System.out.println("\n\n\n\n\n\n\n\nКОЛИЧЕСТВО ПОЛЬЗОВАТЕЛЕЙ СЕРВИСА - " + userRoleService.userCount());
////
//
//        System.out.println("\n\n\n\n\n\n\n\nВСЕ ЗАКАЗЫ КОНКРЕТНОГО ПОЛЬЗОВАТЕЛЯ");
//        for (OfferView i:userService.allUserOffers("pandaXBL262")
//             ) {
//            System.out.println(i);
//
//        }
//
//        System.out.println("\n\n\n\n\n\n\nКОЛИЧЕСТВО  ЗАКАЗОВ ПОЛЬЗОВАТЕЛЯ - " + userService.countOfUserOffers("pandaXBL262"));
//
//
//        BrandEnum brandEnum = BrandEnum.LADA;
//        System.out.println("\n\n\n\n\n\n\n\nКОЛИЧЕСТВА ПРОДАЖ БРЕНДА " + brandEnum.name() + " - " + brandService.brandSales(brandEnum));
//
//        System.out.println("\n\n\n\n\n\n\n\nCУММА СДЕЛОК КОНКРЕТНОГО БРЕНДА " + brandEnum.name() + " - " + brandService.brandProfit(brandEnum) + "РУБ.");
//
//        System.out.println("\n\n\n\n\n\n\nВСЕ МОДЕЛИ БРЕНДА");
//        for (ModelView i:brandService.allBrandModels(brandEnum.name()))
//         {
//            System.out.println(i);
//
//        }
//
//
//
//
//
//   }
//
//}
