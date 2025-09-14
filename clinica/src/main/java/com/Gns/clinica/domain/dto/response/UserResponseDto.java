package com.Gns.clinica.domain.dto.response;


import com.Gns.clinica.domain.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponseDto(
        String dni,
        String firstName,
        String lastName,
        String email,
        String phone,
        Role role,
        SpecialtyPublicResponseDto specialties
) {
}
