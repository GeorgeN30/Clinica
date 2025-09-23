package com.Gns.clinica.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ConsultationRequestDto(
        @NotNull(message = "Reservation ID is required")
        Long idReservation,

        @NotNull(message = "Patient ID is required")
        Long idPatient,

        @NotNull(message = "Doctor ID is required")
        Long idDoctor,

        @NotNull(message = "Consultation date is required")
        @PastOrPresent(message = "Consultation date cannot be in the future")
        LocalDate consultationDate,

        String reason,
        String diagnosis,
        String treatment,
        String notes
) {
}
