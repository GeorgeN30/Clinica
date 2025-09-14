package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;

import java.util.List;

public interface SpecialtyRepository {
    List<SpecialtyResponseDto> getAll();
    SpecialtyResponseDto getSpecialtyByName(String name);
    SpecialtyResponseDto getById(long id);
    SpecialtyRequestDto addSpecialty(SpecialtyRequestDto specialtyRequestDto);
    SpecialtyPublicResponseDto updateSpecialty(long id, SpecialtyPublicResponseDto specialtyPublicResponseDto);
}
