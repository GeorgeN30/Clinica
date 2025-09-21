package com.Gns.clinica.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserPublicResponseDto(
        String dni,
        String firstName,
        String lastName,
        String email,
        String phone,
        String nameSpecialty
) {
}
