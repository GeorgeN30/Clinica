package com.Gns.clinica.domain.dto.response;

import java.time.LocalDate;

public record ConsultationPublicResponseDto(
        Long idReservation,
        String namePatient,
        String nameDoctor,
        String nameSpecialty,
        LocalDate consultationDate,
        String reason,
        String diagnosis,
        String treatment,
        String notes
) {
}
