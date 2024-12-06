package com.vatsaladhiya.apidev.apidev.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vatsaladhiya.apidev.apidev.annotations.EmployeeActiveValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Size(min = 3, max = 10, message = "Number of characters in name must be in range 3-10")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    @Max(value = 80, message = "Age cannot be greater than 80")
    @Min(value = 18, message = "Age cannot be less than 18")
    private Integer age;

    @PastOrPresent(message = "Date of joining cannot be in the future")
    private LocalDate dateOfJoining;

    @EmployeeActiveValidation
    @JsonProperty("isActive")
    private Boolean isActive;
}
