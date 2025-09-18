package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.ReservationEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CrudReservationEntity extends ListCrudRepository<ReservationEntity, Long> {
    ReservationEntity findByPatient_Dni(String dni);
    List<ReservationEntity> findByDoctor_Dni(String dni);

}
