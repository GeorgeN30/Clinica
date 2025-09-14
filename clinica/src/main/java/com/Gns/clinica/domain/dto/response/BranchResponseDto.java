package com.Gns.clinica.domain.dto.response;

public record BranchResponseDto(
        Long idBranch,
        String name,
        String address,
        String phone
) {
}
