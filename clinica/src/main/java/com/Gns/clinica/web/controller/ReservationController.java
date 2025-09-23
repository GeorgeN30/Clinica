package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.domain.service.interfaces.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> getAll(){
        return ResponseEntity.ok(reservationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationPublicResponseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @GetMapping("/doctor/{dni}")
    public ResponseEntity<List<ReservationPublicResponseDto>> getAllByDoctorDni(@PathVariable String dni) {
        return ResponseEntity.ok(reservationService.getAllByDoctorDni(dni));
    }

    @GetMapping("/patient/{dni}")
    public ResponseEntity<ReservationPublicResponseDto> getPublicReservationByDni(@PathVariable String dni){
        return ResponseEntity.ok(reservationService.getPublicReservationByDni(dni));
    }

    @PostMapping
    public ResponseEntity<ReservationPublicResponseDto> addReservation(@Valid @RequestBody ReservationRequestDto reservationRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addReservation(reservationRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationPublicResponseDto> updateReservation(@PathVariable long id, @Valid @RequestBody UpdateReservationDto  updateReservationDto) {
        return ResponseEntity.ok(this.reservationService.updateReservation(id, updateReservationDto));
    }

    @PatchMapping("/{dni}")
    public ResponseEntity<ReservationPublicResponseDto> updateReservationStatus(@PathVariable String dni, @RequestBody UpdateReservationStatusDto updateReservationStatusDto){
        return ResponseEntity.ok(this.reservationService.updateReservationStatus(dni, updateReservationStatusDto));
    }
}
