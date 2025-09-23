package com.Gns.clinica.domain.repository;

import com.Gns.clinica.persistence.entity.ConsultationEntity;

import java.util.List;
import java.util.Optional;

public interface ConsultationRepository {
    List<ConsultationEntity> findAll();
    Optional<ConsultationEntity> findById(long id);
    List<ConsultationEntity> findByDniPatient(String dniPatient);
    List<ConsultationEntity> findByDniDoctor(String dniDoctor);
    ConsultationEntity save(ConsultationEntity consultationRequestDto);
}
