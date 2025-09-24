package com.Gns.clinica.persistence.repository;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.domain.repository.AvailabilityRepository;
import com.Gns.clinica.persistence.crud.CrudAvailabilityEntity;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class AvailabilityEntityRepository implements AvailabilityRepository {
    private final CrudAvailabilityEntity crudAvailabilityEntity;

    @Autowired
    public AvailabilityEntityRepository(CrudAvailabilityEntity crudAvailabilityEntity) {
        this.crudAvailabilityEntity = crudAvailabilityEntity;
    }

    @Override
    public List<AvailabilityEntity> findAll() {
        return this.crudAvailabilityEntity.findAll();
    }

    @Override
    public Optional<AvailabilityEntity> findById(long id) {
        return this.crudAvailabilityEntity.findById(id);
    }

    @Override
    public Optional<AvailabilityEntity> findByDoctorAndDate(Long doctorId, LocalDate date) {
        return this.crudAvailabilityEntity.findByDoctor_IdUserAndDate(doctorId, date);
    }

    @Override
    public Optional<AvailabilityEntity> findAByDateAndStatus(LocalDate date, AvailabilityStatus availabilityStatus) {
        return this.crudAvailabilityEntity.findByDateAndStatus(date, availabilityStatus);
    }

    @Override
    public List<AvailabilityEntity> findAllAvailabilityBetweenDate(LocalDate date, LocalDate date2, AvailabilityStatus availabilityStatus) {
        return this.crudAvailabilityEntity.findByDateBetweenAndStatus(date, date2, availabilityStatus);
    }

    @Override
    public AvailabilityEntity save(AvailabilityEntity availabilityEntity) {
        return this.crudAvailabilityEntity.save(availabilityEntity);
    }
}
