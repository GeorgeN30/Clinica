package com.Gns.clinica.domain.service.impl;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;
import com.Gns.clinica.domain.enums.ReservationStatus;
import com.Gns.clinica.domain.exception.*;
import com.Gns.clinica.domain.repository.ConsultationRepository;
import com.Gns.clinica.domain.repository.ReservationRepository;
import com.Gns.clinica.domain.repository.UserRepository;
import com.Gns.clinica.domain.service.interfaces.ConsultationService;
import com.Gns.clinica.persistence.entity.ConsultationEntity;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import com.Gns.clinica.persistence.mapper.ConsultationMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final ConsultationMapper consultationMapper;
    private final ReservationRepository reservationRepository;


    public ConsultationServiceImpl(ConsultationRepository consultationRepository, ConsultationMapper consultationMapper, ReservationRepository reservationRepository) {
        this.consultationRepository = consultationRepository;
        this.consultationMapper = consultationMapper;
        this.reservationRepository = reservationRepository;
    }


    @Override
    public List<ConsultationResponseDto> getAll() {
        return this.consultationRepository.findAll()
                .stream()
                .map(consultationMapper::toResponseDto)
                .toList();
    }

    @Override
    public ConsultationResponseDto getById(long id) {
        return this.consultationRepository.findById(id)
                .map(consultationMapper::toResponseDto)
                .orElseThrow(() -> new ConsultationNotFoundByIdException(id));
    }

    @Override
    public List<ConsultationPublicResponseDto> getByDniPatient(String dniPatient) {
        List<ConsultationEntity> consultationEntities = this.consultationRepository.findByDniPatient(dniPatient);

        if(consultationEntities.isEmpty()){
            throw new ConsultationNotFoundByDniException(dniPatient);
        }

        return this.consultationRepository.findByDniPatient(dniPatient)
                .stream()
                .map(consultationMapper::toPublicResponseDto)
                .toList();
    }

    @Override
    public List<ConsultationPublicResponseDto> getByDniDoctor(String dniDoctor) {
        List<ConsultationEntity> consultationEntities = this.consultationRepository.findByDniDoctor(dniDoctor);

        if(consultationEntities.isEmpty()){
            throw new ConsultationNotFoundByDniException(dniDoctor);
        }
        return this.consultationRepository.findByDniDoctor(dniDoctor)
                .stream()
                .map(consultationMapper::toPublicResponseDto)
                .toList();
    }

    @Override
    public ConsultationPublicResponseDto addConsultation(ConsultationRequestDto consultationRequestDto) {

        ReservationEntity reservation = reservationRepository.findById(consultationRequestDto.idReservation())
                .orElseThrow(() -> new ReservationNotFoundByIdException(consultationRequestDto.idReservation()));


        UserEntity patient = reservation.getPatient();
        UserEntity doctor = reservation.getDoctor();

        LocalDate consultationDate = reservation.getAvailability().getDate();

        reservation.setStatus(ReservationStatus.COMPLETED);

        ConsultationEntity consultation = consultationMapper.toEntity(consultationRequestDto);
        consultation.setPatient(patient);
        consultation.setDoctor(doctor);
        consultation.setReservation(reservation);
        consultation.setConsultationDate(consultationDate);

        return consultationMapper.toPublicResponseDto(consultationRepository.save(consultation));
    }
}
