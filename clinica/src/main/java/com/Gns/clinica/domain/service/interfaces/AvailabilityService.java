package com.Gns.clinica.domain.service.interfaces;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityService {
    List<AvailabilityResponseDto> getAll();
    AvailabilityResponseDto getById(long id);
    AvailabilityPublicResponseDto getAvailabilityByDateAndStatus(LocalDate date);
    List<AvailabilityPublicResponseDto> getAllAvailabilityBetweenDate(LocalDate date, LocalDate date2);
    AvailabilityPublicResponseDto addAvailability (AvailabilityRequestDto availabilityRequestDto);
    AvailabilityPublicResponseDto updateAvailability (long id, AvailabilityRequestDto availabilityRequestDto);
    AvailabilityPublicResponseDto updateAvailabilityStatus(long id, UpdateAvailabilityStatusDto availabilityStatusDto);
}
