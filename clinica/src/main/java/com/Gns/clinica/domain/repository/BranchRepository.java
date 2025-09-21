package com.Gns.clinica.domain.repository;

import com.Gns.clinica.persistence.entity.BranchEntity;

import java.util.List;
import java.util.Optional;

public interface BranchRepository {
    List<BranchEntity> findAll();
    Optional<BranchEntity> findById(long id);
    Optional<BranchEntity> findByName(String name);
    BranchEntity save(BranchEntity BranchEntity);

}
