package com.Gns.clinica.web.controller;


import com.Gns.clinica.domain.dto.SpecialtyDto;
import com.Gns.clinica.domain.service.SpecialtyService;
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
    public ResponseEntity<List<SpecialtyDto>> findAll() {
        return ResponseEntity.ok(specialtyService.findAll());
    }

    @GetMapping("/name/{specialty}")
    public ResponseEntity<SpecialtyDto> getByName(@PathVariable String specialty) {
        return ResponseEntity.ok(specialtyService.findByName(specialty));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SpecialtyDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(specialtyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SpecialtyDto> add(@RequestBody SpecialtyDto specialtyDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.specialtyService.addSpecialty(specialtyDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDto> update(@PathVariable long id, @RequestBody SpecialtyDto specialtyDto) {
        return ResponseEntity.ok(this.specialtyService.updateSpecialty(id, specialtyDto));
    }
}
