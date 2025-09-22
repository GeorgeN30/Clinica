package com.Gns.clinica.domain.dto.request;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AvailabilityRequestDto(
        @NotNull(message = "Doctor ID cannot be null")
        Long idDoctor,

        @NotNull(message = "Date cannot be null")
        @FutureOrPresent(message = "Date cannot be in the past")
        LocalDate date,

        @NotNull(message = "Start time cannot be null")
        LocalTime startTime,

        @NotNull(message = "End time cannot be null")
        LocalTime endTime,

        @NotNull(message = "Status cannot be null")
        AvailabilityStatus status
) {
}
