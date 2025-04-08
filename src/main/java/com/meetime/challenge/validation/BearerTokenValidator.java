package com.meetime.challenge.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BearerTokenValidator implements ConstraintValidator<ValidBearerToken, String> {
    @Override
    public boolean isValid(String token, ConstraintValidatorContext context) {
        return token != null && token.startsWith("Bearer ") && token.length() > 7;
    }
}