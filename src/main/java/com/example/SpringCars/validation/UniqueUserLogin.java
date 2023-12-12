package com.example.SpringCars.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUserLoginValidator.class)
public @interface UniqueUserLogin {
    String message() default "Указанный логин уже занят";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
