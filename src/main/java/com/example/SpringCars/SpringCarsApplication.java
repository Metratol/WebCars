package com.example.SpringCars;
import com.example.SpringCars.init.factories.BaseFactory;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.services.OfferService;
import com.example.SpringCars.validation.ValidationUtil;
import com.example.SpringCars.validation.ValidationUtilImpl;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;
@SpringBootApplication
public class SpringCarsApplication {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }
    @Bean
    public Validator validator() {
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringCarsApplication.class, args);
    }
    @Component
    public class DataInput implements CommandLineRunner {
        private OfferService offerService;
        private BaseFactory baseFactory;
        public DataInput(OfferService offerService, BaseFactory baseFactory) {
            this.offerService = offerService;
            this.baseFactory = baseFactory;
        }
        @Override
        public void run(String... args) throws Exception {
            List<Offer> offers = baseFactory.listBuilder().offers(100, 100);
            offerService.saveAllOffers(offers);
        }
    }
}