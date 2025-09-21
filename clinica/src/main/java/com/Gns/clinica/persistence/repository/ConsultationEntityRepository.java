package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;
import com.Gns.clinica.domain.repository.ConsultationRepository;
import com.Gns.clinica.persistence.crud.CrudConsultationEntity;
import com.Gns.clinica.persistence.entity.ConsultationEntity;
import com.Gns.clinica.persistence.mapper.ConsultationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultationEntityRepository implements ConsultationRepository {
    private final CrudConsultationEntity crudConsultationEntity;
    private final ConsultationMapper consultationMapper;

    @Autowired
    public ConsultationEntityRepository(CrudConsultationEntity crudConsultationEntity, ConsultationMapper consultationMapper) {
        this.crudConsultationEntity = crudConsultationEntity;
        this.consultationMapper = consultationMapper;
    }

    @Override
    public List<ConsultationResponseDto> getAll() {
        return this.consultationMapper.toResponseDto(this.crudConsultationEntity.findAll());
    }

    @Override
    public ConsultationResponseDto getById(long id) {
        return this.consultationMapper.toResponseDto(this.crudConsultationEntity.findById(id).orElse(null));
    }

    @Override
    public List<ConsultationPublicResponseDto> getByDniPatient(String dniPatient) {
        return this.consultationMapper.toPublicResponseDto(this.crudConsultationEntity.findByPatient_Dni(dniPatient));
    }

    @Override
    public List<ConsultationPublicResponseDto> getByDniDoctor(String dniDoctor) {
        return this.consultationMapper.toPublicResponseDto(this.crudConsultationEntity.findByDoctor_Dni(dniDoctor));
    }


    @Override
    public ConsultationRequestDto addConsultation(ConsultationRequestDto consultationRequestDto) {
        ConsultationEntity  consultationEntity = this.consultationMapper.toEntity(consultationRequestDto);
        return this.consultationMapper.toRequestDto(this.crudConsultationEntity.save(consultationEntity));
    }
}
