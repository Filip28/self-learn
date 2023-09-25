package com.app.selflearn.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record PersonDto(
        @NotEmpty(message = "Name can't be empty.")
        @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
        String name,
        @NotEmpty(message = "Surname can't be empty")
        @Size(min = 2, max = 100, message = "The length of surname must be between 2 and 100 characters.")
        String surname,
        @Min(value = 1, message = "The age should be bigger than 1.")
        @Max(value = 200, message = "The age should be lower than 200.")
        int age,
        @Min(value = 1, message = "The height should be higher than 1.")
        double height,

        @NotEmpty(message = "Gender can't be empty.")
        @Pattern(regexp = "\\b(?:MAN|WOMAN|OTHER)\\b", message = "The gender must be MAN, WOMAN or OTHER.")
        String gender
) {
}
