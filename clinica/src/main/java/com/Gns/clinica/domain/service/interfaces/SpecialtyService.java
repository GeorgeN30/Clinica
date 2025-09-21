package com.Gns.clinica.domain.service.interfaces;

import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;

import java.util.List;

public interface SpecialtyService {
    List<SpecialtyResponseDto> getAll();
    SpecialtyPublicResponseDto getSpecialtyByName(String name);
    List<SpecialtyPublicResponseDto>  getAllPublicSpecialty();
    SpecialtyResponseDto getById(long id);
    SpecialtyPublicResponseDto addSpecialty(SpecialtyRequestDto specialtyRequestDto);
    SpecialtyPublicResponseDto updateSpecialty(long id, SpecialtyRequestDto SpecialtyRequestDto);
}
