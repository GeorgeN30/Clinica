package com.Gns.clinica.domain.dto.request.update;

import com.Gns.clinica.domain.enums.AvailabilityStatus;

public record UpdateAvailabilityStatusDto(
        AvailabilityStatus status
) {
}
