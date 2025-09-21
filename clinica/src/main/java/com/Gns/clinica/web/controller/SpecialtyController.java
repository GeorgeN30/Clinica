package com.Gns.clinica.web.controller;


import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;
import com.Gns.clinica.domain.service.interfaces.SpecialtyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @Autowired
    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyResponseDto>> getAll() {
        return ResponseEntity.ok(this.specialtyService.getAll());
    }

    @GetMapping("/name/{specialty}")
    public ResponseEntity<SpecialtyPublicResponseDto> getByName(@PathVariable String specialty) {
        return ResponseEntity.ok(this.specialtyService.getSpecialtyByName(specialty));
    }

    @GetMapping("/public")
    public ResponseEntity<List<SpecialtyPublicResponseDto>> getAllPublicSpecialty() {
        return ResponseEntity.ok(this.specialtyService.getAllPublicSpecialty());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SpecialtyResponseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(specialtyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SpecialtyPublicResponseDto> add(@Valid @RequestBody SpecialtyRequestDto specialtyRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.specialtyService.addSpecialty(specialtyRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyPublicResponseDto> update(@PathVariable long id, @Valid @RequestBody SpecialtyRequestDto specialtyRequestDto) {
        return ResponseEntity.ok(this.specialtyService.updateSpecialty(id, specialtyRequestDto));
    }
}
