package com.Gns.clinica.domain.dto.response;

import com.Gns.clinica.domain.enums.AvailabilityStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record AvailabilityResponseDto(
        Long idAvailability,
        Long idDoctor,
        String nameDoctor,
        Long idSpecialty,
        String nameSpecialty,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        AvailabilityStatus status
) {
}
