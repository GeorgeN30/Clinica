package com.Gns.clinica.domain.dto.request;

import com.Gns.clinica.domain.enums.ReservationStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationRequestDto(
        Long idPatient,
        Long idDoctor,
        Long idBranch,
        Long idAvailability,
        LocalDate reservationDate,
        LocalTime reservationTime,
        ReservationStatus status

) {
}
