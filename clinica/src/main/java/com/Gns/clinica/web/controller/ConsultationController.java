package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;
import com.Gns.clinica.domain.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {
    private final ConsultationService consultationService;


    @Autowired
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultationResponseDto>> getAll(){
        return ResponseEntity.ok(this.consultationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationResponseDto> getById(@PathVariable long id){
        return ResponseEntity.ok(this.consultationService.getById(id));
    }

    @GetMapping("/patient/{dni}")
    public ResponseEntity<List<ConsultationPublicResponseDto>> getByDniPatient(@PathVariable String dni){
        return ResponseEntity.ok(this.consultationService.getByDniPatient(dni));
    }

    @GetMapping("/doctor/{dni}")
    public ResponseEntity<List<ConsultationPublicResponseDto>> getByDniDoctor(@PathVariable String dni){
        return ResponseEntity.ok(this.consultationService.getByDniDoctor(dni));
    }

    @PostMapping
    public ResponseEntity<ConsultationRequestDto> ddConsultation(@RequestBody ConsultationRequestDto consultationRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.consultationService.addConsultation(consultationRequestDto));
    }

}
