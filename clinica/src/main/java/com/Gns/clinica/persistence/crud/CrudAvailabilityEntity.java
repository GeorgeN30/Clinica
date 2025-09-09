package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CrudAvailabilityEntity extends ListCrudRepository<AvailabilityEntity, Long> {
}
