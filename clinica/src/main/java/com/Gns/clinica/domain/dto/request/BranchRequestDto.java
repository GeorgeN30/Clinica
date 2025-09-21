package com.Gns.clinica.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BranchRequestDto (
        @NotBlank(message = "Name cannot be empty")
        String name,

        @NotBlank(message = "Address cannot be empty")
        String address,

        String phone
){
}
