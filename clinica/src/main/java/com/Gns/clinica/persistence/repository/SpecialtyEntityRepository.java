package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.dto.SpecialtyDto;
import com.Gns.clinica.domain.repository.SpecialtyRepository;
import com.Gns.clinica.persistence.crud.CrudSpecialtyEntity;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.mapper.SpecialtyMapper;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialtyEntityRepository implements SpecialtyRepository {
    private final CrudSpecialtyEntity crudSpecialtyEntity;
    private final SpecialtyMapper specialtyMapper;

    @Autowired
    public SpecialtyEntityRepository(CrudSpecialtyEntity crudSpecialtyEntity, SpecialtyMapper specialtyMapper) {
        this.crudSpecialtyEntity = crudSpecialtyEntity;
        this.specialtyMapper = specialtyMapper;
    }

    @Override
    public List<SpecialtyDto> getAll() {
        return this.specialtyMapper.toDto(this.crudSpecialtyEntity.findAll());
    }

    @Override
    public SpecialtyDto getSpecialtyByName(String name) {
        return this.specialtyMapper.toDto(this.crudSpecialtyEntity.findByNameSpecialty(name));
    }

    @Override
    public SpecialtyDto getById(long id) {
        return this.specialtyMapper.toDto(this.crudSpecialtyEntity.findById(id).orElse(null));
    }

    @Override
    public SpecialtyDto addSpecialty(SpecialtyDto specialtyDto) {
        SpecialtyEntity specialtyEntity = this.specialtyMapper.toEntity(specialtyDto);
        return this.specialtyMapper.toDto(this.crudSpecialtyEntity.save(specialtyEntity));
    }

    @Override
    public SpecialtyDto updateSpecialty(long id, SpecialtyDto specialtyDto) {
        SpecialtyEntity specialtyEntity = this.crudSpecialtyEntity.findById(id).orElse(null);
        this.specialtyMapper.updateEntityFromDto(specialtyDto, specialtyEntity);
        if (specialtyEntity == null) {
            return null;
        }
        return this.specialtyMapper.toDto(crudSpecialtyEntity.save(specialtyEntity));
    }
}
