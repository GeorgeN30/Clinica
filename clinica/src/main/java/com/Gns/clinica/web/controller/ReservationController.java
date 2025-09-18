package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.domain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<ReservationResponseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<ReservationResponseDto>> getAllByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(reservationService.getAllByDate(date));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<ReservationPublicResponseDto> getPublicReservationByDni(@PathVariable String dni){
        return ResponseEntity.ok(reservationService.getPublicReservationByDni(dni));
    }

    @PostMapping
    public ResponseEntity<ReservationRequestDto> addReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addReservation(reservationRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationRequestDto> updateReservation(@PathVariable long id, @RequestBody UpdateReservationDto  updateReservationDto) {
        return ResponseEntity.ok(this.reservationService.updateReservation(id, updateReservationDto));
    }

    @PatchMapping("/{dni}")
    public ResponseEntity<ReservationRequestDto> updateReservationStatus(@PathVariable String dni, @RequestBody UpdateReservationStatusDto updateReservationStatusDto){
        return ResponseEntity.ok(this.reservationService.updateReservationStatus(dni, updateReservationStatusDto));
    }
}
