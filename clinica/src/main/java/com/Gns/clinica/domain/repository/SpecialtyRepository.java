package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.SpecialtyDto;

import java.util.List;

public interface SpecialtyRepository {
    List<SpecialtyDto> getAll();
    SpecialtyDto getSpecialtyByName(String name);
    SpecialtyDto getById(long id);
    SpecialtyDto addSpecialty(SpecialtyDto specialtyDto);
    SpecialtyDto updateSpecialty(long id, SpecialtyDto specialtyDto);
}
