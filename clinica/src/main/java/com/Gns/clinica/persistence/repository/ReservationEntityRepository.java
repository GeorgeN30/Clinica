package com.Gns.clinica.persistence.repository;
import com.Gns.clinica.domain.repository.ReservationRepository;
import com.Gns.clinica.persistence.crud.CrudReservationEntity;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationEntityRepository implements ReservationRepository {
    private final CrudReservationEntity crudReservationEntity;

    @Autowired
    public ReservationEntityRepository(CrudReservationEntity crudReservationEntity) {
        this.crudReservationEntity = crudReservationEntity;
    }

    @Override
    public List<ReservationEntity> findAll() {
        return this.crudReservationEntity.findAll();
    }

    @Override
    public Optional<ReservationEntity> findById(long id) {
        return this.crudReservationEntity.findById(id);
    }

    @Override
    public List<ReservationEntity> findAllByDoctorDni(String dni) {
        return this.crudReservationEntity.findAllByDoctor_Dni(dni);
    }

    @Override
    public Optional<ReservationEntity> findByDoctorDni(String dni) {
        return this.crudReservationEntity.findByDoctor_Dni(dni);
    }

    @Override
    public Optional<ReservationEntity> findPublicReservationByDni(String dni) {
        return this.crudReservationEntity.findFirstByPatient_DniOrderByReservationDateDesc(dni);
    }

    @Override
    public ReservationEntity save(ReservationEntity reservationEntity) {
        return this.crudReservationEntity.save(reservationEntity);
    }

    @Override
    public Long countByDoctor(LocalDate date, Long doctorId) {
        return this.crudReservationEntity
                .countByAvailability_DateAndDoctor_IdUser(date, doctorId);
    }

    @Override
    public Long countBySpecialty(LocalDate date, Long specialtyId) {
       return this.crudReservationEntity
               .countByAvailability_DateAndDoctor_Specialties_IdSpecialty(date, specialtyId);
    }
}
