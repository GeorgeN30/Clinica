package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;

import java.util.List;

public interface ConsultationRepository {
    List<ConsultationResponseDto> getAll();
    ConsultationResponseDto getById(long id);
    List<ConsultationPublicResponseDto> getByDniPatient(String dniPatient);
    List<ConsultationPublicResponseDto> getByDniDoctor(String dniDoctor);
    ConsultationRequestDto addConsultation(ConsultationRequestDto consultationRequestDto);
}
