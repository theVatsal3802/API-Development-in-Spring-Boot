package com.vatsaladhiya.apidev.apidev.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeActiveValidator implements ConstraintValidator<EmployeeActiveValidation, Boolean> {
    @Override
    public boolean isValid(Boolean isActive, ConstraintValidatorContext constraintValidatorContext) {
        return isActive ? true : false;
    }
}
