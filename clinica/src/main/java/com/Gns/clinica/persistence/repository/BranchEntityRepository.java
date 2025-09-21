package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.repository.BranchRepository;
import com.Gns.clinica.persistence.crud.CrudBranchEntity;
import com.Gns.clinica.persistence.entity.BranchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class BranchEntityRepository implements BranchRepository {
    private final CrudBranchEntity crudBranchEntity;

    @Autowired
    public BranchEntityRepository(CrudBranchEntity crudBranchEntity) {
        this.crudBranchEntity = crudBranchEntity;
    }

    @Override
    public List<BranchEntity> findAll() {
        return this.crudBranchEntity.findAll();
    }

    @Override
    public Optional<BranchEntity> findById(long id) {
        return this.crudBranchEntity.findById(id);
    }

    @Override
    public Optional<BranchEntity> findByName(String name) {
        return  this.crudBranchEntity.findByName(name);
    }

    @Override
    public BranchEntity save(BranchEntity BranchEntity) {
        return this.crudBranchEntity.save(BranchEntity);
    }
}
