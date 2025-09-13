package com.Gns.clinica.domain.dto.request.update;

public record UpdateUserDto (
        String firstName,
        String lastName,
        String email,
        String phone,
        Long idSpecialty
){
}
