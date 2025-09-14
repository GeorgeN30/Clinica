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
    public List<SpecialtyResponseDto> getAll() {
        return this.specialtyMapper.toDto(this.crudSpecialtyEntity.findAll());
    }

    @Override
    public SpecialtyPublicResponseDto getSpecialtyByName(String name) {
        return this.specialtyMapper.toPublicDto(this.crudSpecialtyEntity.findByNameSpecialty(name));
    }

    @Override
    public SpecialtyResponseDto getById(long id) {
        return this.specialtyMapper.toDto(this.crudSpecialtyEntity.findById(id).orElse(null));
    }

    @Override
    public SpecialtyRequestDto addSpecialty(SpecialtyRequestDto specialtyRequestDto) {
        SpecialtyEntity specialtyEntity = this.specialtyMapper.toEntity(specialtyRequestDto);
        return this.specialtyMapper.toRequestDto(this.crudSpecialtyEntity.save(specialtyEntity));
    }

    @Override
    public SpecialtyRequestDto updateSpecialty(long id, SpecialtyRequestDto specialtyRequestDto) {
        SpecialtyEntity specialtyEntity = this.crudSpecialtyEntity.findById(id).orElse(null);
        this.specialtyMapper.updateEntityFromDto(specialtyRequestDto, specialtyEntity);
        if (specialtyEntity == null) {
            return null;
        }
        return this.specialtyMapper.toRequestDto(crudSpecialtyEntity.save(specialtyEntity));
    }
}
