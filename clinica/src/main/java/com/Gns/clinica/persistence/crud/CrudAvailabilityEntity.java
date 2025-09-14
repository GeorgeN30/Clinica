package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CrudAvailabilityEntity extends ListCrudRepository<AvailabilityEntity, Long> {
    AvailabilityEntity findByDateAndStatus(LocalDate date, AvailabilityStatus availabilityStatus);
    List<AvailabilityEntity> findByDateBetweenAndStatus(LocalDate date, LocalDate date2, AvailabilityStatus status);

}
