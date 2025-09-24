package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.ReservationEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CrudReservationEntity extends ListCrudRepository<ReservationEntity, Long> {
    Optional<ReservationEntity> findFirstByPatient_DniOrderByReservationDateDesc(String dni);
    Optional<ReservationEntity> findByDoctor_Dni(String dni);
    List<ReservationEntity> findAllByDoctor_Dni(String dni);
    long countByAvailability_DateAndDoctor_IdUser(LocalDate date, Long doctorId);
    long countByAvailability_DateAndDoctor_Specialties_IdSpecialty(LocalDate date, Long specialtyId);

}
