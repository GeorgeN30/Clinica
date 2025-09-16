package com.Gns.clinica.domain.dto.request.update;

import java.time.LocalDate;
import java.time.LocalTime;

public record UpdateReservationDto(
        Long idDoctor,
        Long idBranch,
        Long idAvailability,
        LocalDate reservationDate,
        LocalTime reservationTime
) {
}
