package com.Gns.clinica.domain.dto.request;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import java.time.LocalDate;
import java.time.LocalTime;

public record AvailabilityRequestDto(
        Long idDoctor,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        AvailabilityStatus status
) {
}
