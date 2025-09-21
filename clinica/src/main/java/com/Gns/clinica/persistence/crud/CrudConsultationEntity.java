package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.ConsultationEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CrudConsultationEntity extends ListCrudRepository<ConsultationEntity, Long> {
    List<ConsultationEntity> findByPatient_Dni(String dniPatient);
    List<ConsultationEntity> findByDoctor_Dni(String dniPatient);
}
