package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;
import com.Gns.clinica.domain.repository.SpecialtyRepository;
import com.Gns.clinica.persistence.crud.CrudSpecialtyEntity;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyEntityRepository implements SpecialtyRepository {
    private final CrudSpecialtyEntity crudSpecialtyEntity;

    @Autowired
    public SpecialtyEntityRepository(CrudSpecialtyEntity crudSpecialtyEntity) {
        this.crudSpecialtyEntity = crudSpecialtyEntity;
    }

    @Override
    public List<SpecialtyEntity> findAll() {
        return this.crudSpecialtyEntity.findAll();
    }

    @Override
    public Optional<SpecialtyEntity> findSpecialtyByName(String name) {
        return this.crudSpecialtyEntity.findByNameSpecialty(name);
    }

    @Override
    public  Optional<SpecialtyEntity> findById(long id) {
        return this.crudSpecialtyEntity.findById(id);
    }

    @Override
    public SpecialtyEntity save(SpecialtyEntity specialtyEntity) {
        return this.crudSpecialtyEntity.save(specialtyEntity);
    }
}
