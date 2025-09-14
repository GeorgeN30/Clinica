package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository {

    List<AvailabilityResponseDto> getAll();
    AvailabilityResponseDto getById(long id);
    AvailabilityPublicResponseDto getAvailabilityByDateAndStatus(LocalDate date, AvailabilityStatus availabilityStatus);
    List<AvailabilityPublicResponseDto> getAllAvailabilityBetweenDate(LocalDate date, LocalDate date2, AvailabilityStatus availabilityStatus);
    AvailabilityRequestDto addAvailability (AvailabilityRequestDto availabilityRequestDto);
    AvailabilityRequestDto updateAvailability (long id, AvailabilityRequestDto availabilityRequestDto);
    UpdateAvailabilityStatusDto  updateAvailabilityStatus(long id, UpdateAvailabilityStatusDto availabilityStatusDto);
}
