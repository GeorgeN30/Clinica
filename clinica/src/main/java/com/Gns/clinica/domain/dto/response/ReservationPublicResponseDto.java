package com.Gns.clinica.domain.dto.response;

import com.Gns.clinica.domain.enums.ReservationStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationPublicResponseDto (
        String namePatient,
        String nameDoctor,
        String nameSpecialty,
        String nameBranch,
        LocalDate reservationDate,
        LocalTime reservationTime,
        ReservationStatus status
){
}
