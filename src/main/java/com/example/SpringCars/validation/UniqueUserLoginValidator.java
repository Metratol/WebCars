package com.example.SpringCars.validation;
import com.example.SpringCars.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserLoginValidator implements ConstraintValidator<UniqueUserLogin,String> {

    private final UserRepository userRepository;


    public UniqueUserLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository.findUserByUsername(value).isEmpty();
    }
}
