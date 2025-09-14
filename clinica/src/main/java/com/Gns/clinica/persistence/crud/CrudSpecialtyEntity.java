package com.Gns.clinica.persistence.crud;


import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CrudSpecialtyEntity extends ListCrudRepository<SpecialtyEntity, Long> {
    SpecialtyEntity findByNameSpecialty(String name);
}
