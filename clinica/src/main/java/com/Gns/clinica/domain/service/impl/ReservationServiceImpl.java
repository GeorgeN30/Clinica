package com.Gns.clinica.domain.service.impl;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.domain.enums.ReservationStatus;
import com.Gns.clinica.domain.exception.*;
import com.Gns.clinica.domain.repository.AvailabilityRepository;
import com.Gns.clinica.domain.repository.BranchRepository;
import com.Gns.clinica.domain.repository.ReservationRepository;
import com.Gns.clinica.domain.repository.UserRepository;
import com.Gns.clinica.domain.service.interfaces.ReservationService;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import com.Gns.clinica.persistence.entity.BranchEntity;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import com.Gns.clinica.persistence.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final AvailabilityRepository availabilityRepository;
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationRepository reservationRepository1, ReservationMapper reservationMapper, AvailabilityRepository availabilityRepository, UserRepository userRepository, BranchRepository branchRepository) {
        this.reservationRepository = reservationRepository1;
        this.reservationMapper = reservationMapper;
        this.availabilityRepository = availabilityRepository;
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
    }


    @Override
    public List<ReservationResponseDto> getAll() {
        return this.reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toResponseDto)
                .toList();
    }

    @Override
    public ReservationPublicResponseDto getById(long id) {
        return this.reservationRepository.findById(id)
                .map(reservationMapper::toPublicResponseDto)
                .orElseThrow(()-> new ReservationNotFoundByIdException(id));
    }

    @Override
    public List<ReservationPublicResponseDto> getAllByDoctorDni(String dni) {
        ReservationEntity reservationEntity = this.reservationRepository.findByDoctorDni(dni)
                .orElseThrow(()-> new DoctorNotFoundByDniException(dni));

        return this.reservationRepository.findAllByDoctorDni(dni)
                .stream()
                .map(reservationMapper::toPublicResponseDto)
                .toList();
    }

    @Override
    public ReservationPublicResponseDto getPublicReservationByDni(String dni) {
        return this.reservationRepository.findPublicReservationByDni(dni)
                .map(reservationMapper::toPublicResponseDto)
                .orElseThrow(()-> new ReservationNotFoundByDniException(dni));
    }

    @Override
    public ReservationPublicResponseDto addReservation(ReservationRequestDto reservationRequestDto) {
        UserEntity patient = getUserOrThrow(reservationRequestDto.idPatient());
        UserEntity doctor = getUserOrThrow(reservationRequestDto.idDoctor());
        BranchEntity branch = getBranchOrThrow(reservationRequestDto.idBranch());
        AvailabilityEntity availability = getAvailabilityOrThrow(reservationRequestDto.idAvailability());


        if (reservationRequestDto.reservationDate().isBefore(LocalDate.now())) {
            throw new AvailabilityInvalidDateException(reservationRequestDto.reservationDate());
        }
        if (availability.getStatus() != AvailabilityStatus.AVAILABLE) {
            throw new AvailabilityInvalidStatusException(reservationRequestDto.idAvailability());
        }

        ReservationEntity reservation = reservationMapper.toEntity(reservationRequestDto);
        reservation.setPatient(patient);
        reservation.setDoctor(doctor);
        reservation.setBranch(branch);
        reservation.setAvailability(availability);
        reservation.setStatus(ReservationStatus.PENDING);

        return reservationMapper.toPublicResponseDto(reservationRepository.save(reservation));
    }

    @Override
    public ReservationPublicResponseDto updateReservation(long id, UpdateReservationDto updateReservationDto) {

        ReservationEntity reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundByIdException(id));

        UserEntity updateDoctor = getUserOrThrow(updateReservationDto.idDoctor());
        BranchEntity updateBranch = getBranchOrThrow(updateReservationDto.idBranch());
        AvailabilityEntity updateAvailability = getAvailabilityOrThrow(updateReservationDto.idAvailability());


        if (updateReservationDto.reservationDate().isBefore(LocalDate.now())) {
            throw new AvailabilityInvalidDateException(updateReservationDto.reservationDate());
        }
        if (updateAvailability.getStatus() != AvailabilityStatus.AVAILABLE) {
            throw new AvailabilityInvalidStatusException(updateReservationDto.idAvailability());
        }


        reservation.setDoctor(updateDoctor);
        reservation.setBranch(updateBranch);
        reservation.setAvailability(updateAvailability);
        reservation.setReservationDate(updateReservationDto.reservationDate());
        reservation.setReservationTime(updateReservationDto.reservationTime());

        return reservationMapper.toPublicResponseDto(reservationRepository.save(reservation));
    }

    @Override
    public ReservationPublicResponseDto updateReservationStatus(String dni, UpdateReservationStatusDto updateReservationStatusDto) {
        ReservationEntity reservation = reservationRepository.findPublicReservationByDni(dni)
                .orElseThrow(() -> new ReservationNotFoundByDniException(dni));

        reservation.setStatus(updateReservationStatusDto.status());
        ReservationEntity updatedReservation = reservationRepository.save(reservation);
        return reservationMapper.toPublicResponseDto(updatedReservation);
    }


    private UserEntity getUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundByIdException(id));
    }

    private BranchEntity getBranchOrThrow(Long id) {
        return branchRepository.findById(id)
                .orElseThrow(() -> new BranchNotFoundByIdException(id));
    }

    private AvailabilityEntity getAvailabilityOrThrow(Long id) {
        return availabilityRepository.findById(id)
                .orElseThrow(() -> new AvailabilityNotFoundException(id));
    }

}
