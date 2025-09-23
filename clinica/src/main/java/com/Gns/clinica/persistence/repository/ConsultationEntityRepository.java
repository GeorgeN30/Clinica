package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.repository.ConsultationRepository;
import com.Gns.clinica.persistence.crud.CrudConsultationEntity;
import com.Gns.clinica.persistence.entity.ConsultationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsultationEntityRepository implements ConsultationRepository {
    private final CrudConsultationEntity crudConsultationEntity;

    @Autowired
    public ConsultationEntityRepository(CrudConsultationEntity crudConsultationEntity) {
        this.crudConsultationEntity = crudConsultationEntity;
    }

    @Override
    public List<ConsultationEntity> findAll() {
        return this.crudConsultationEntity.findAll();
    }

    @Override
    public Optional<ConsultationEntity> findById(long id) {
        return this.crudConsultationEntity.findById(id);
    }

    @Override
    public List<ConsultationEntity> findByDniPatient(String dniPatient) {
        return this.crudConsultationEntity.findByPatient_Dni(dniPatient);
    }

    @Override
    public List<ConsultationEntity> findByDniDoctor(String dniDoctor) {
        return this.crudConsultationEntity.findByDoctor_Dni(dniDoctor);
    }

    @Override
    public ConsultationEntity save(ConsultationEntity consultationRequestDto) {
        return this.crudConsultationEntity.save(consultationRequestDto);
    }
}
