package com.Gns.clinica.domain.dto.response;
import java.time.LocalDate;
import java.time.LocalTime;

public record AvailabilityPublicResponseDto(
        String nameDoctor,
        String nameSpecialty,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime
) {
}
