package com.vatsaladhiya.apidev.apidev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Title must not be blank")
    @Size(min = 3, max = 50, message = "Title must be between 3 - 50 characters in length")
    private String title;

    @JsonProperty("isActive")
    private Boolean isActive;

    @PastOrPresent(message = "Date of creation cannot be in the future")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdAt;

    public DepartmentDTO(String title, Boolean isActive) {
        this.title = title;
        this.isActive = isActive;
        this.createdAt = LocalDateTime.now();
    }
}
