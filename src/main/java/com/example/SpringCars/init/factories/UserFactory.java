package com.example.SpringCars.init.factories;

import com.example.SpringCars.models.User;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class UserFactory {
//        private static LocalDateTime created = new LocalDate(
//                LocalDateTime.of(2009, 1, 1,0,0,0).toEpochSecond(ZoneOffset.MAX));
        public static User createUser() {
        User user = new User();
        Faker faker = new Faker();

        user.setId(UUID.fromString(faker.internet().uuid()));
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setActive(faker.bool().bool());
        user.setImageUrl(faker.internet().url());
        user.setPassword(faker.internet().password(8,24));
        return user;


}

}
