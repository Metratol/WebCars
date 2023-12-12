package com.example.SpringCars.init.factories;

import com.example.SpringCars.models.*;
import com.example.SpringCars.models.enums.*;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseFactory {
Faker faker = new Faker();
UserRole user= new UserRole(RoleEnum.USER);
UserRole admin= new UserRole(RoleEnum.ADMIN);
List<UserRole> roles = new ArrayList<>(2);

Brand bmw = new Brand(BrandEnum.BMW.name(),created(),modified());
Brand chevrolet = new Brand(BrandEnum.CHEVROLET.name(),created(),modified());
Brand toyota = new Brand(BrandEnum.TOYOTA.name(),created(),modified());
Brand lada = new Brand(BrandEnum.LADA.name(),created(),modified());
Brand haval = new Brand(BrandEnum.HAVAL.name(),created(),modified());
List<Brand> brands = new ArrayList<>(5);




public LocalDateTime created() {
return faker.date()
.past(20 * 365, 12 * 365, TimeUnit.DAYS)
.toInstant()
.atOffset(ZoneOffset.UTC)
.toLocalDateTime();
}

public LocalDateTime bound() {
return faker.date()
.past(10 * 365, TimeUnit.DAYS)
.toInstant()
.atOffset(ZoneOffset.UTC)
.toLocalDateTime();
}

public LocalDateTime modified() {
Date date1 = Date.from(created().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
Date date2 = Date.from(bound().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
return faker.date().between(date1, date2).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime();
}

public CategoryEnum categoryRandom() {
int pick = new Random().nextInt(CategoryEnum.values().length);
return CategoryEnum.values()[pick];
}

public EngineEnum engineRandom() {
int pick = new Random().nextInt(EngineEnum.values().length);
return EngineEnum.values()[pick];
}

public TransmissionEnum transmissionRandom() {
int pick = new Random().nextInt(TransmissionEnum.values().length);
return TransmissionEnum.values()[pick];
}

public UserRole roleRandom() {
int pick = new Random().nextInt(RoleEnum.values().length);
roles.add(user);
roles.add(admin);
return roles.get(pick);
}

public Brand brandRandom() {
int pick = new Random().nextInt(BrandEnum.values().length);
brands.add(lada);
brands.add(haval);
brands.add(bmw);
brands.add(toyota);
brands.add(chevrolet);
return brands.get(pick);
}


public String name() {
return faker.ancient().god() + faker.address().countryCode();
}

public String imageUrl() {
return faker.internet().image();
}

public String description() {
return faker.weather().description();
}

public Integer startYear() {
return faker.random().nextInt(1988, 2005);
}

public String username() {
return ((faker.animal().name() + faker.address().buildingNumber()).replace(" ",""));
}
public String password() {
return faker.internet().password();
}

public String firstname() {
return faker.name().firstName();
}

public String lastname() {
return faker.name().lastName();
}


public Integer endYear() {
return faker.random().nextInt(2005, 2017);
}


public Integer price() {
return faker.random().nextInt(500000, 5000000);
}

public Integer mileage() {
return faker.random().nextInt(7, 300000);
}

public Model model() {
return new Model(name(), categoryRandom(), startYear(), endYear(),created(),modified(),imageUrl(), brandRandom());
}

public User user() {
return new User(faker.random().nextBoolean(), username(),  firstname(), lastname(),password(),created(),modified(),imageUrl(),  roleRandom());
}


final Offer make(UnaryOperator<Offer>... offers) {
final Offer result = new Offer(description(), engineRandom(),price(),transmissionRandom(),endYear(), created(),modified(),  mileage(),  imageUrl(), user(), model());
Stream.of(offers).forEach(v -> v.apply(result));
return result;
}

public BaseFactory.BaseListDtoFactory listBuilder() {
return new BaseListDtoFactory();
}

public class BaseListDtoFactory {
public List<Offer> offers(int min, int max, UnaryOperator<Offer>... offers) {
return IntStream.range(0, faker.number().numberBetween(min, max))
.mapToObj(i -> BaseFactory.this.make(offers))
.collect(Collectors.toList());
}
}
}