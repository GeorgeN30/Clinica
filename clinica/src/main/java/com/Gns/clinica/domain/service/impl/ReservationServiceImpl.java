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
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final AvailabilityRepository availabilityRepository;
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;


    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, AvailabilityRepository availabilityRepository, UserRepository userRepository, BranchRepository branchRepository) {
        this.reservationRepository = reservationRepository;
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


        if (availability.getStatus() != AvailabilityStatus.AVAILABLE) {
            throw new AvailabilityInvalidStatusException(reservationRequestDto.idAvailability());
        }

        LocalDate appointmentDate = availability.getDate();
        Long doctorId = doctor.getIdUser();
        Long specialtyId = doctor.getSpecialties().getIdSpecialty();


        long doctorReservations = reservationRepository.countByDoctor(appointmentDate, doctorId);
        if (doctorReservations >= 3) {
            throw new DoctorReachedDailyReservationLimitException(doctor.getFirstName(), doctor.getLastName());
        }

        long specialtyReservations = reservationRepository.countBySpecialty(appointmentDate, specialtyId);
        if (specialtyReservations >= 9) {
            throw new SpecialtyReachedDailyReservationException();
        }


        ReservationEntity reservation = reservationMapper.toEntity(reservationRequestDto);
        reservation.setPatient(patient);
        reservation.setDoctor(doctor);
        reservation.setBranch(branch);
        reservation.setAvailability(availability);
        reservation.setReservationDate(LocalDate.now());
        reservation.setReservationTime(LocalTime.now());
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

        if (updateAvailability.getDate().isBefore(LocalDate.now())) {
            throw new AvailabilityInvalidDateException(updateAvailability.getDate());
        }
        if (updateAvailability.getStatus() != AvailabilityStatus.AVAILABLE) {
            throw new AvailabilityInvalidStatusException(updateReservationDto.idAvailability());
        }


        reservation.setDoctor(updateDoctor);
        reservation.setBranch(updateBranch);
        reservation.setAvailability(updateAvailability);
        reservation.setReservationDate(LocalDate.now());
        reservation.setReservationTime(LocalTime.now());

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

    @Override
    public long countByDoctor(LocalDate date, long doctorId) {
        return this.reservationRepository.countByDoctor(date, doctorId);
    }

    @Override
    public long countBySpecialty(LocalDate date, long specialtyId) {
        return this.reservationRepository.countBySpecialty(date, specialtyId);
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
