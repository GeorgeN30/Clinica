package com.Gns.clinica.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SpecialtyRequestDto(
        @NotBlank(message = "Name specialty cannot be empty")
        String nameSpecialty
) {
}
