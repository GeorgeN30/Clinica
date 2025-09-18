package com.Gns.clinica.domain.dto.request;

import java.time.LocalDate;

public record ConsultationRequestDto(
        Long idReservation,
        Long idPatient,
        Long idDoctor,
        LocalDate consultationDate,
        String reason,
        String diagnosis,
        String treatment,
        String notes
) {
}
