package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.ReservationEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CrudReservationEntity extends ListCrudRepository<ReservationEntity, Long> {
}
