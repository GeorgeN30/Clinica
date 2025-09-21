package com.Gns.clinica.domain.dto.request;

import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.enums.UserStatus;
import jakarta.validation.constraints.*;

public record UserRequestDto(
        @NotBlank(message = "DNI cannot be empty")
        @Size(min = 8, max = 8, message = "DNI must have 8 characters")
        String dni,

        @NotBlank(message = "Name cannot be empty")
        String firstName,

        @NotBlank(message = "Last Name cannot be empty")
        String lastName,

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Email invalid")
        String email,

        @NotBlank(message = "Password cannot be empty")
        @Size(min = 6, message = "password minimum 6 characters")
        String password,

        String phone,
        Role role,
        UserStatus status,
        Boolean disabled,
        Boolean locked,
        Long idSpecialty
) {

}
