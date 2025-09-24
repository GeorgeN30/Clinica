package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailabilityRepository {

    List<AvailabilityEntity> findAll();
    Optional<AvailabilityEntity> findById(long id);
    Optional<AvailabilityEntity> findByDoctorAndDate(Long doctorId, LocalDate date);
    Optional<AvailabilityEntity> findAByDateAndStatus(LocalDate date, AvailabilityStatus availabilityStatus);
    List<AvailabilityEntity> findAllAvailabilityBetweenDate(LocalDate date, LocalDate date2, AvailabilityStatus availabilityStatus);
    AvailabilityEntity save (AvailabilityEntity availabilityEntity);


}
