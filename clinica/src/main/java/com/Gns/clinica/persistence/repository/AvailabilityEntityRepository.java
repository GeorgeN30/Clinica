package com.Gns.clinica.persistence.repository;
import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.domain.repository.AvailabilityRepository;
import com.Gns.clinica.persistence.crud.CrudAvailabilityEntity;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import com.Gns.clinica.persistence.mapper.AvailabilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public class AvailabilityEntityRepository implements AvailabilityRepository {
    private final CrudAvailabilityEntity crudAvailabilityEntity;
    private final AvailabilityMapper availabilityMapper;

    @Autowired
    public AvailabilityEntityRepository(CrudAvailabilityEntity crudAvailabilityEntity, AvailabilityMapper availabilityMapper) {
        this.crudAvailabilityEntity = crudAvailabilityEntity;
        this.availabilityMapper = availabilityMapper;
    }

    @Override
    public List<AvailabilityResponseDto> getAll() {
        return this.availabilityMapper.toResponseDto(crudAvailabilityEntity.findAll());
    }

    @Override
    public AvailabilityResponseDto getById(long id) {
        return this.availabilityMapper.toResponseDto(this.crudAvailabilityEntity.findById(id).orElse(null));
    }

    @Override
    public AvailabilityPublicResponseDto getAvailabilityByDateAndStatus(LocalDate date, AvailabilityStatus availabilityStatus) {
        return this.availabilityMapper.toPublicResponseDto(this.crudAvailabilityEntity.findByDateAndStatus(date, availabilityStatus));
    }

    @Override
    public List<AvailabilityPublicResponseDto> getAllAvailabilityBetweenDate(LocalDate date, LocalDate date2, AvailabilityStatus status) {
        return this.availabilityMapper.toPublicResponseDto(this.crudAvailabilityEntity.findByDateBetweenAndStatus(date, date2, status));
    }

    @Override
    public AvailabilityRequestDto addAvailability(AvailabilityRequestDto availabilityRequestDto) {
        AvailabilityEntity  availabilityEntity = this.availabilityMapper.toEntity(availabilityRequestDto);
        return this.availabilityMapper.toRequestDto(this.crudAvailabilityEntity.save(availabilityEntity));
    }

    @Override
    public AvailabilityRequestDto updateAvailability(long id, AvailabilityRequestDto availabilityRequestDto) {
        AvailabilityEntity availabilityEntity = this.crudAvailabilityEntity.findById(id).orElse(null);
        if (availabilityEntity == null) {
            return null;
        }
        this.availabilityMapper.updateToEntityFromDto(availabilityRequestDto, availabilityEntity);
        return this.availabilityMapper.toRequestDto(this.crudAvailabilityEntity.save(availabilityEntity));
    }

    @Override
    public UpdateAvailabilityStatusDto updateAvailabilityStatus(long id, UpdateAvailabilityStatusDto updateAvailabilityStatusDto) {
        AvailabilityEntity availabilityEntity = this.crudAvailabilityEntity.findById(id).orElse(null);
        if (availabilityEntity == null) {
            return null;
        }
        this.availabilityMapper.updateStatusToEntityFromDto(updateAvailabilityStatusDto, availabilityEntity);
        return this.availabilityMapper.toStatusRequestDto(this.crudAvailabilityEntity.save(availabilityEntity));

    }
}
