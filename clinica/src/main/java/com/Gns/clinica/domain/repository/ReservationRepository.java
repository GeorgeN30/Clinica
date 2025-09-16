package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository {
    List<ReservationResponseDto> getAll();
    ReservationResponseDto getById(long id);
    List<ReservationResponseDto> getAllByDate(LocalDate date);
    ReservationPublicResponseDto getPublicReservationByDni(String dni);
    ReservationRequestDto addReservation(ReservationRequestDto reservationRequestDto);
    UpdateReservationDto updateReservation(UpdateReservationDto updateReservationDto);
    UpdateReservationStatusDto updateReservationStatus(UpdateReservationStatusDto updateReservationStatusDto);
}
