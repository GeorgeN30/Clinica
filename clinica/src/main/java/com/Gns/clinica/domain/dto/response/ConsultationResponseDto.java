package com.Gns.clinica.domain.dto.response;

import java.time.LocalDate;

public record ConsultationResponseDto (
        Long idConsultation,
        Long idReservation,
        Long idPatient,
        String namePatient,
        Long idDoctor,
        String nameDoctor,
        String nameSpecialty,
        LocalDate consultationDate,
        String reason,
        String diagnosis,
        String treatment,
        String notes
){

}
