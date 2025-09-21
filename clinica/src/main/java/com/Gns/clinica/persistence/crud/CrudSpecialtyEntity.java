package com.Gns.clinica.persistence.crud;


import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CrudSpecialtyEntity extends ListCrudRepository<SpecialtyEntity, Long> {
    Optional<SpecialtyEntity> findByNameSpecialty(String name);
}
