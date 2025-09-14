package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    private final AvailabilityService  availabilityService;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping
    public ResponseEntity<List<AvailabilityResponseDto>> getAll(){
        return ResponseEntity.ok(this.availabilityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailabilityResponseDto> getById(@PathVariable long id){
        return ResponseEntity.ok(this.availabilityService.getById(id));
    }


    @GetMapping("/date/{date}")
    public ResponseEntity<AvailabilityPublicResponseDto> getAvailabilityByDateAndStatus(@PathVariable LocalDate date){
        return ResponseEntity.ok(this.availabilityService.getAvailabilityByDateAndStatus(date));
    }

    @GetMapping("/dates/{starDate}/{endDate}")
    public ResponseEntity<List<AvailabilityPublicResponseDto>> getAllAvailabilityBetweenDate(@PathVariable LocalDate starDate, @PathVariable LocalDate endDate){
        return ResponseEntity.ok(this.availabilityService.getAllAvailabilityBetweenDate(starDate, endDate));
    }

    @PostMapping
    public ResponseEntity<AvailabilityRequestDto> addAvailability(@RequestBody AvailabilityRequestDto availabilityRequestDto){
        return ResponseEntity.ok(this.availabilityService.addAvailability(availabilityRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvailabilityRequestDto> updateAvailability(@PathVariable long id, @RequestBody AvailabilityRequestDto availabilityRequestDto){
        return ResponseEntity.ok(this.availabilityService.updateAvailability(id, availabilityRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateAvailabilityStatusDto> updateAvailabilityStatus(@PathVariable long id, @RequestBody UpdateAvailabilityStatusDto availabilityStatusDto){
        return ResponseEntity.ok(this.availabilityService.updateAvailabilityStatus(id, availabilityStatusDto));
    }

}
