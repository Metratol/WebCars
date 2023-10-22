package com.example.SpringCars.init.factories;

import com.example.SpringCars.models.*;
import com.example.SpringCars.models.enums.*;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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

public RoleEnum roleRandom() {
int pick = new Random().nextInt(RoleEnum.values().length);
return RoleEnum.values()[pick];
}

public BrandEnum vehicleBrandsEnum() {
int pick = new Random().nextInt(BrandEnum.values().length);
return BrandEnum.values()[pick];
}


public String name() {
return faker.music().chord();
}

public String imageUrl() {
return faker.internet().image();
}

public String description() {
return faker.superhero().descriptor();
}

public Integer startYear() {
return faker.random().nextInt(2000, 2010);
}

public String username() {
return faker.animal().name() + faker.programmingLanguage().name() +faker.address().buildingNumber();
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
return faker.random().nextInt(2010, 2020);
}


public Integer price() {
return faker.random().nextInt(500000, 5000000);
}

public Integer mileage() {
return faker.random().nextInt(7, 300000);
}

public Brand brand() {
return new Brand(vehicleBrandsEnum().name());
}

public Model model() {
return new Model(name(), categoryRandom(), startYear(), endYear(),imageUrl(), brand());
}

public User user() {
return new User(faker.random().nextBoolean(), username(),  firstname(), lastname(),password(),imageUrl(),  role());
}

public UserRole role() {
return new UserRole(roleRandom());
}


final Offer make(UnaryOperator<Offer>... offers) {
final Offer result = new Offer(description(), engineRandom(),price(),transmissionRandom(),endYear(),  mileage(),  imageUrl(), user(), model());
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