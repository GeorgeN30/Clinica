package com.Gns.clinica.domain.repository;

import com.Gns.clinica.persistence.entity.ReservationEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    List<ReservationEntity> findAll();
    Optional<ReservationEntity> findById(long id);
    List<ReservationEntity> findAllByDoctorDni(String dni);
    Optional<ReservationEntity> findByDoctorDni(String dni);
    Optional<ReservationEntity> findPublicReservationByDni(String dni);
    ReservationEntity save(ReservationEntity reservationEntity);
    Long countByDoctor(LocalDate date, Long doctorId);
    Long countBySpecialty(LocalDate date, Long specialtyId);
}
