package com.Gns.clinica.domain.service.impl;

import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;
import com.Gns.clinica.domain.exception.SpecialtyAlreadyExistsException;
import com.Gns.clinica.domain.exception.SpecialtyNotFoundByIdException;
import com.Gns.clinica.domain.exception.SpecialtyNotFoundByNameException;
import com.Gns.clinica.domain.repository.SpecialtyRepository;
import com.Gns.clinica.domain.service.interfaces.SpecialtyService;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyMapper specialtyMapper;

    @Autowired
    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository, SpecialtyMapper specialtyMapper) {
        this.specialtyRepository = specialtyRepository;
        this.specialtyMapper = specialtyMapper;
    }


    @Override
    public List<SpecialtyResponseDto> getAll() {
        return this.specialtyRepository.findAll()
                .stream()
                .map(specialtyMapper::toResponseDto)
                .toList();
    }

    @Override
    public SpecialtyPublicResponseDto getSpecialtyByName(String name) {
        return this.specialtyRepository.findSpecialtyByName(name)
                .map(specialtyMapper::toPublicResponseDto)
                .orElseThrow(() -> new SpecialtyNotFoundByNameException(name));
    }

    @Override
    public List<SpecialtyPublicResponseDto> getAllPublicSpecialty() {
        return this.specialtyRepository.findAll().stream()
                .map(specialtyMapper::toPublicResponseDto)
                .toList();
    }

    @Override
    public SpecialtyResponseDto getById(long id) {
        return this.specialtyRepository.findById(id)
                .map(specialtyMapper::toResponseDto)
                .orElseThrow(() -> new SpecialtyNotFoundByIdException(id));
    }

    @Override
    public SpecialtyPublicResponseDto addSpecialty(SpecialtyRequestDto specialtyRequestDto) {
        this.specialtyRepository.findSpecialtyByName(specialtyRequestDto.nameSpecialty())
                .ifPresent(specialty -> {
                    throw new SpecialtyAlreadyExistsException(specialtyRequestDto.nameSpecialty());
                });

        SpecialtyEntity  specialtyEntity = this.specialtyMapper.toEntity(specialtyRequestDto);
        return this.specialtyMapper.toPublicResponseDto(this.specialtyRepository.save(specialtyEntity));
    }

    @Override
    public SpecialtyPublicResponseDto updateSpecialty(long id, SpecialtyRequestDto SpecialtyRequestDto) {
        SpecialtyEntity existing = this.specialtyRepository.findById(id)
                .orElseThrow(() -> new SpecialtyNotFoundByIdException(id));

        existing.setNameSpecialty(SpecialtyRequestDto.nameSpecialty());

        SpecialtyEntity specialtyEntity = this.specialtyRepository.save(existing);
        return this.specialtyMapper.toPublicResponseDto(specialtyEntity);
    }

}
