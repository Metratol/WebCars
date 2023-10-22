package com.example.SpringCars.init;

import com.example.SpringCars.init.factories.BaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration{
    @Bean
    public BaseFactory baseDtoFactory(){return new BaseFactory();}
}