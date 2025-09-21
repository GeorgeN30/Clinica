package com.Gns.clinica.domain.repository;


import com.Gns.clinica.persistence.entity.SpecialtyEntity;

import java.util.List;
import java.util.Optional;

public interface SpecialtyRepository {
    List<SpecialtyEntity> findAll();
    Optional<SpecialtyEntity> findSpecialtyByName(String name);
    Optional<SpecialtyEntity> findById(long id);
    SpecialtyEntity save(SpecialtyEntity specialtyEntity);

}
