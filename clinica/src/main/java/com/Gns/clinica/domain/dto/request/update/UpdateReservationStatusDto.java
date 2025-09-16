package com.Gns.clinica.domain.dto.request.update;

import com.Gns.clinica.domain.enums.ReservationStatus;

public record UpdateReservationStatusDto(
        ReservationStatus status
) {
}
