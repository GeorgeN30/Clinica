package com.Gns.clinica.domain.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationRequestDto(
        @NotNull(message = "Patient ID is required")
        @Positive(message = "Patient ID must be a positive number")
        Long idPatient,

        @NotNull(message = "Doctor ID is required")
        @Positive(message = "Doctor ID must be a positive number")
        Long idDoctor,

        @NotNull(message = "Branch ID is required")
        @Positive(message = "Branch ID must be a positive number")
        Long idBranch,

        @NotNull(message = "Availability ID is required")
        @Positive(message = "Availability ID must be a positive number")
        Long idAvailability,

        @NotNull(message = "Reservation date is required")
        @FutureOrPresent(message = "Reservation date must be today or in the future")
        LocalDate reservationDate,

        @NotNull(message = "Reservation time is required")
        LocalTime reservationTime

) {
}
