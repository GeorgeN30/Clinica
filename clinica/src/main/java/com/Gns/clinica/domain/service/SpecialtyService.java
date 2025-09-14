package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.SpecialtyDto;
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

    public List<SpecialtyDto> findAll() {
        return this.specialtyRepository.getAll();
    }

    public SpecialtyDto findByName(String name) {
        return this.specialtyRepository.getSpecialtyByName(name);
    }

    public SpecialtyDto findById(long id) {
        return this.specialtyRepository.getById(id);
    }

    public SpecialtyDto addSpecialty(SpecialtyDto specialtyDto) {
        return this.specialtyRepository.addSpecialty(specialtyDto);
    }

    public SpecialtyDto updateSpecialty(long id, SpecialtyDto specialtyDto) {
        return this.specialtyRepository.updateSpecialty(id, specialtyDto);
    }
}
