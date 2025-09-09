package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.ConsultationEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CrudConsultationEntity extends ListCrudRepository<ConsultationEntity, Long> {
}
