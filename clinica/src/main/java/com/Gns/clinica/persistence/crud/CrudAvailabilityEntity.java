package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CrudAvailabilityEntity extends ListCrudRepository<AvailabilityEntity, Long> {
    Optional<AvailabilityEntity> findByDateAndStatus(LocalDate date, AvailabilityStatus availabilityStatus);
    List<AvailabilityEntity> findByDateBetweenAndStatus(LocalDate date, LocalDate date2, AvailabilityStatus status);
    Optional<AvailabilityEntity> findByDoctor_IdUserAndDate(Long idUser, LocalDate date);
}
