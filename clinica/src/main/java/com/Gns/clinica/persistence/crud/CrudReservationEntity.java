package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.ReservationEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface CrudReservationEntity extends ListCrudRepository<ReservationEntity, Long> {
    Optional<ReservationEntity> findByPatient_Dni(String dni);
    Optional<ReservationEntity> findByDoctor_Dni(String dni);
    List<ReservationEntity> findAllByDoctor_Dni(String dni);

}
