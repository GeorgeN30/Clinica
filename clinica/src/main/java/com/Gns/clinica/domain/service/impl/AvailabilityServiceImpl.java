package com.Gns.clinica.domain.service.impl;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.domain.exception.*;
import com.Gns.clinica.domain.repository.AvailabilityRepository;
import com.Gns.clinica.domain.repository.UserRepository;
import com.Gns.clinica.domain.service.interfaces.AvailabilityService;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import com.Gns.clinica.persistence.mapper.AvailabilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final AvailabilityMapper availabilityMapper;
    private final UserRepository userRepository;

    @Autowired
    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository, AvailabilityMapper availabilityMapper, UserRepository userRepository) {
        this.availabilityRepository = availabilityRepository;
        this.availabilityMapper = availabilityMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<AvailabilityResponseDto> getAll() {
        return this.availabilityRepository.findAll()
                .stream()
                .map(availabilityMapper::toResponseDto)
                .toList();
    }

    @Override
    public AvailabilityResponseDto getById(long id) {
        return this.availabilityRepository.findById(id)
                .map(availabilityMapper::toResponseDto)
                .orElseThrow(()-> new AvailabilityNotFoundException(id));
    }

    @Override
    public AvailabilityPublicResponseDto getAvailabilityByDateAndStatus(LocalDate date) {
        AvailabilityEntity availabilityEntity = this.availabilityRepository.findAByDateAndStatus(date, AvailabilityStatus.AVAILABLE)
                .orElseThrow(()-> new AvailabilityNotFoundByDateException(date));

        return availabilityMapper.toPublicResponseDto(availabilityEntity);
    }

    @Override
    public List<AvailabilityPublicResponseDto> getAllAvailabilityBetweenDate(LocalDate date, LocalDate date2) {
        LocalDate today = LocalDate.now();
        if (date.isBefore(today) || date2.isBefore(today)) {
            throw new AvailabilityInvalidDateException(date);
        }

        List<AvailabilityEntity> availabilityEntities = this.availabilityRepository
                .findAllAvailabilityBetweenDate(date, date2, AvailabilityStatus.AVAILABLE);

        return availabilityEntities.stream()
                .map(availabilityMapper::toPublicResponseDto)
                .toList();
    }

    @Override
    public AvailabilityPublicResponseDto addAvailability(AvailabilityRequestDto availabilityRequestDto) {
        LocalDate date = availabilityRequestDto.date();
        if (date.isBefore(LocalDate.now())) {
            throw new AvailabilityInvalidDateException(date);
        }
        UserEntity doctor = userRepository.findById(availabilityRequestDto.idDoctor())
                .orElseThrow(() -> new UserNotFoundByIdException(availabilityRequestDto.idDoctor()));

        this.availabilityRepository.findByDoctorAndDate(doctor.getIdUser(), date)
                .ifPresent(existing -> {
                    throw new DoctorAlreadyHasAvailabilityException(doctor.getFirstName(), doctor.getLastName(), date);
                });

        AvailabilityEntity entity = availabilityMapper.toEntity(availabilityRequestDto);
        entity.setDoctor(doctor);
        entity.setStatus(AvailabilityStatus.AVAILABLE);
        AvailabilityEntity saved = this.availabilityRepository.save(entity);

        return availabilityMapper.toPublicResponseDto(saved);
    }

    @Override
    public AvailabilityPublicResponseDto updateAvailability(long id, AvailabilityRequestDto availabilityRequestDto) {
        AvailabilityEntity existing = availabilityRepository.findById(id)
                .orElseThrow(() -> new AvailabilityNotFoundException(id));

        LocalDate date = availabilityRequestDto.date();
        LocalTime startTime = availabilityRequestDto.startTime();
        LocalTime endTime = availabilityRequestDto.endTime();

        if (date.isBefore(LocalDate.now())) {
            throw new AvailabilityInvalidDateException(date);
        }

        existing.setDate(date);
        existing.setStartTime(startTime);
        existing.setEndTime(endTime);
        existing.setStatus(availabilityRequestDto.status());

        AvailabilityEntity updated = availabilityRepository.save(existing);

        return availabilityMapper.toPublicResponseDto(updated);
    }

    @Override
    public AvailabilityPublicResponseDto updateAvailabilityStatus(long id, UpdateAvailabilityStatusDto availabilityStatusDto) {
        AvailabilityEntity existing = availabilityRepository.findById(id)
                .orElseThrow(() -> new AvailabilityNotFoundException(id));

        existing.setStatus(availabilityStatusDto.status());
        AvailabilityEntity updated = availabilityRepository.save(existing);
        return availabilityMapper.toPublicResponseDto(updated);
    }
}
