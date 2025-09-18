package com.Gns.clinica.domain.dto.response;


import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponseDto(
        Long idUser,
        String dni,
        String firstName,
        String lastName,
        String email,
        String phone,
        Role role,
        UserStatus status,
        Boolean disabled,
        Boolean locked,
        Long idSpecialty,
        String nameSpecialty
) {
}
