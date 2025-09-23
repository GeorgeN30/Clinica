package com.Gns.clinica.domain.service.interfaces;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    List<ReservationResponseDto> getAll();
    ReservationPublicResponseDto getById(long id);
    List<ReservationPublicResponseDto> getAllByDoctorDni(String dni);
    ReservationPublicResponseDto getPublicReservationByDni(String dni);
    ReservationPublicResponseDto addReservation(ReservationRequestDto reservationRequestDto);
    ReservationPublicResponseDto updateReservation(long id, UpdateReservationDto updateReservationDto);
    ReservationPublicResponseDto updateReservationStatus(String dni, UpdateReservationStatusDto updateReservationStatusDto);
}
