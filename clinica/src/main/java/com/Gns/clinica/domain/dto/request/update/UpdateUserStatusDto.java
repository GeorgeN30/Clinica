package com.Gns.clinica.domain.dto.request.update;

import com.Gns.clinica.domain.enums.UserStatus;

public record UpdateUserStatusDto(
        UserStatus status,
        Boolean disabled,
        Boolean locked
) {
}
