package com.Gns.clinica.domain.dto.request;

import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDtoRequest(
        String dni,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        Role role,
        UserStatus status,
        Long idSpecialty
) {

}
