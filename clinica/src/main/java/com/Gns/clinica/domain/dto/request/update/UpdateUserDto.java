package com.Gns.clinica.domain.dto.request.update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto (
        @NotBlank(message = "Name cannot be empty")
        String firstName,

        @NotBlank(message = "Last Name cannot be empty")
        String lastName,

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Email invalid")
        String email,

        String phone,
        Long idSpecialty
){
}
