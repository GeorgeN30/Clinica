package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.domain.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public List<ReservationResponseDto> getAll(){
        return this.reservationRepository.getAll();
    }

    public ReservationResponseDto getById(long id){
        return this.reservationRepository.getById(id);
    }

    public List<ReservationResponseDto> getAllByDate(LocalDate date){
        return this.reservationRepository.getAllByDate(date);
    }

    public ReservationPublicResponseDto getPublicReservationByDni(String dni){
        return this.reservationRepository.getPublicReservationByDni(dni);
    }

    public ReservationRequestDto addReservation(ReservationRequestDto reservationRequestDto){
        return this.reservationRepository.addReservation(reservationRequestDto);
    }

    public  ReservationRequestDto updateReservation(long id, UpdateReservationDto updateReservationDto){
        return this.reservationRepository.updateReservation(id, updateReservationDto);
    }

    public ReservationRequestDto updateReservationStatus(String dni, UpdateReservationStatusDto updateReservationStatusDto){
        return this.reservationRepository.updateReservationStatus(dni, updateReservationStatusDto);
    }

}
