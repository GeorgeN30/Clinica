package com.Gns.clinica.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ConsultationRequestDto(
        @NotNull(message = "Reservation ID is required")
        Long idReservation,
        String reason,
        String diagnosis,
        String treatment,
        String notes
) {
}
