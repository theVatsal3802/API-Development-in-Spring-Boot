package com.vatsaladhiya.apidev.apidev.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(
        validatedBy = {EmployeeActiveValidator.class}
)
public @interface EmployeeActiveValidation {
    String message() default "isActive must be true or false";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
