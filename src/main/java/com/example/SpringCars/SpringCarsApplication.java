package com.example.SpringCars;

import com.example.SpringCars.init.factories.BaseFactory;
import com.example.SpringCars.models.Offer;
import com.example.SpringCars.services.OfferService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class SpringCarsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringCarsApplication.class, args);
	}

	@Component
	public class DataInitializer implements CommandLineRunner {
		private OfferService offerService;
		private BaseFactory baseFactory;

		public DataInitializer(OfferService offerService, BaseFactory baseFactory) {
			this.offerService = offerService;
			this.baseFactory = baseFactory;
		}

		@Override
		public void run(String... args) throws Exception {
			List<Offer> offers = baseFactory.listBuilder().offers(100,100);
			offerService.saveAllOffers(offers);
		}

	}
}