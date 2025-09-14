package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.domain.repository.AvailabilityRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityService {
    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }
    public List<AvailabilityResponseDto> getAll(){
        return this.availabilityRepository.getAll();
    }

    public AvailabilityResponseDto getById(long id){
        return this.availabilityRepository.getById(id);
    }

    public AvailabilityPublicResponseDto getAvailabilityByDateAndStatus(LocalDate date){
        AvailabilityStatus available = AvailabilityStatus.AVAILABLE;
        return this.availabilityRepository.getAvailabilityByDateAndStatus(date,available);
    }

    public List<AvailabilityPublicResponseDto> getAllAvailabilityBetweenDate(LocalDate date, LocalDate date2){
        AvailabilityStatus available = AvailabilityStatus.AVAILABLE;
        return this.availabilityRepository.getAllAvailabilityBetweenDate(date, date2, available);
    }

    public AvailabilityRequestDto addAvailability (AvailabilityRequestDto availabilityRequestDto){
        return this.availabilityRepository.addAvailability(availabilityRequestDto);
    }

    public AvailabilityRequestDto updateAvailability (long id, AvailabilityRequestDto availabilityRequestDto){
        return this.availabilityRepository.updateAvailability(id, availabilityRequestDto);
    }

    public UpdateAvailabilityStatusDto updateAvailabilityStatus(long id, UpdateAvailabilityStatusDto availabilityStatusDto){
        return this.availabilityRepository.updateAvailabilityStatus(id, availabilityStatusDto);
    }


}
