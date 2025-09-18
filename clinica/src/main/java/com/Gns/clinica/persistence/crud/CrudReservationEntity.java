package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.ReservationEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CrudReservationEntity extends ListCrudRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByReservationDate(LocalDate date);
    ReservationEntity findByPatient_Dni(String dni);

}
