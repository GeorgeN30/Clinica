package com.Gns.clinica.persistence.repository;
import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.domain.repository.ReservationRepository;
import com.Gns.clinica.persistence.crud.CrudReservationEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReservationEntityRepository implements ReservationRepository {
    private final CrudReservationEntity crudReservationEntity;

    public ReservationEntityRepository(CrudReservationEntity crudReservationEntity) {
        this.crudReservationEntity = crudReservationEntity;
    }

    @Override
    public List<ReservationResponseDto> getAll() {
        return List.of();
    }

    @Override
    public ReservationResponseDto getById(long id) {
        return null;
    }

    @Override
    public List<ReservationResponseDto> getAllByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public ReservationPublicResponseDto getPublicReservationByDni(String dni) {
        return null;
    }

    @Override
    public ReservationRequestDto addReservation(ReservationRequestDto reservationRequestDto) {
        return null;
    }

    @Override
    public UpdateReservationDto updateReservation(UpdateReservationDto updateReservationDto) {
        return null;
    }

    @Override
    public UpdateReservationStatusDto updateReservationStatus(UpdateReservationStatusDto updateReservationStatusDto) {
        return null;
    }
}
