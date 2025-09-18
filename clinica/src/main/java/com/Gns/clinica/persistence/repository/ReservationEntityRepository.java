package com.Gns.clinica.persistence.repository;
import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.domain.repository.ReservationRepository;
import com.Gns.clinica.persistence.crud.CrudReservationEntity;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import com.Gns.clinica.persistence.mapper.ReservationMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReservationEntityRepository implements ReservationRepository {
    private final CrudReservationEntity crudReservationEntity;
    private final ReservationMapper reservationMapper;

    public ReservationEntityRepository(CrudReservationEntity crudReservationEntity, ReservationMapper reservationMapper) {
        this.crudReservationEntity = crudReservationEntity;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public List<ReservationResponseDto> getAll() {
        return this.reservationMapper.toResponseDto(this.crudReservationEntity.findAll());
    }

    @Override
    public ReservationResponseDto getById(long id) {
        return this.reservationMapper.toResponseDto(this.crudReservationEntity.findById(id).orElse(null));
    }

    @Override
    public List<ReservationResponseDto> getAllByDate(LocalDate date) {
        return this.reservationMapper.toResponseDto(this.crudReservationEntity.findByReservationDate(date));
    }

    @Override
    public ReservationPublicResponseDto getPublicReservationByDni(String dni) {
        return this.reservationMapper.toPublicResponseDto(this.crudReservationEntity.findByPatient_Dni(dni));
    }

    @Override
    public ReservationRequestDto addReservation(ReservationRequestDto reservationRequestDto) {
        ReservationEntity reservationEntity = this.reservationMapper.toEntity(reservationRequestDto);
        return this.reservationMapper.toRequestDto(this.crudReservationEntity.save(reservationEntity));
    }

    @Override
    public ReservationRequestDto updateReservation(long id, UpdateReservationDto updateReservationDto) {
        ReservationEntity reservationEntity = this.crudReservationEntity.findById(id).orElse(null);
        if (reservationEntity == null) {
            return null;
        }
        this.reservationMapper.toUpdateDto(updateReservationDto, reservationEntity);
        return this.reservationMapper.toRequestDto(reservationEntity);
    }

    @Override
    public ReservationRequestDto updateReservationStatus(String dni, UpdateReservationStatusDto updateReservationStatusDto) {
        ReservationEntity reservationEntity = this.crudReservationEntity.findByPatient_Dni(dni);
        if (reservationEntity == null) {
            return null;
        }
        this.reservationMapper.toUpdateStatusDto(updateReservationStatusDto, reservationEntity);
        return this.reservationMapper.toRequestDto(this.crudReservationEntity.save(reservationEntity));
    }
}
