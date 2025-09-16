package com.Gns.clinica.domain.dto.response;

import com.Gns.clinica.domain.enums.ReservationStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationResponseDto (
        Long idReservation,
        Long idPatient,
        String namePatient,
        Long idDoctor,
        String nameDoctor,
        String nameSpecialty,
        Long idBranch,
        String nameBranch,
        Long idAvailability,
        LocalDate reservationDate,
        LocalTime reservationTime,
        ReservationStatus status
){
}
