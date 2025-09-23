package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.persistence.entity.ReservationEntity;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    List<ReservationEntity> findAll();
    Optional<ReservationEntity> findById(long id);
    List<ReservationEntity> findAllByDoctorDni(String dni);
    Optional<ReservationEntity> findByDoctorDni(String dni);
    Optional<ReservationEntity> findPublicReservationByDni(String dni);
    ReservationEntity save(ReservationEntity reservationEntity);

}
