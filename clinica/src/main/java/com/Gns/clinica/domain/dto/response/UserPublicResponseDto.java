package com.Gns.clinica.domain.dto.response;

public record UserPublicResponseDto(
        String dni,
        String firstName,
        String lastName,
        String email,
        String phone,
        String nameSpecialty
) {
}
