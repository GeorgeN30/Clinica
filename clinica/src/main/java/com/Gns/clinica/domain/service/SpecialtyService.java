package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;
import com.Gns.clinica.domain.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public List<SpecialtyResponseDto> findAll() {
        return this.specialtyRepository.getAll();
    }

    public SpecialtyPublicResponseDto findByName(String name) {
        return this.specialtyRepository.getSpecialtyByName(name);
    }

    public SpecialtyResponseDto findById(long id) {
        return this.specialtyRepository.getById(id);
    }

    public SpecialtyRequestDto addSpecialty(SpecialtyRequestDto specialtyRequestDto) {
        return this.specialtyRepository.addSpecialty(specialtyRequestDto);
    }

    public SpecialtyRequestDto updateSpecialty(long id, SpecialtyRequestDto specialtyRequestDto) {
        return this.specialtyRepository.updateSpecialty(id, specialtyRequestDto);
    }
}
