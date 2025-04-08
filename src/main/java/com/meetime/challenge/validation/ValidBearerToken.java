package com.meetime.challenge.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BearerTokenValidator.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD }) // PARAMETER is required for method args
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBearerToken {
    String message() default "Invalid Bearer token";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}