package com.Gns.clinica.domain.dto.request;

import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.enums.UserStatus;

public record UserRequestDto(
        String dni,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        Role role,
        UserStatus status,
        Boolean disabled,
        Boolean locked,
        Long idSpecialty
) {

}
