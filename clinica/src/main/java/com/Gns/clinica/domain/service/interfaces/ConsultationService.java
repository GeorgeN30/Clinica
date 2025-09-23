package com.Gns.clinica.domain.service.interfaces;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;

import java.util.List;

public interface ConsultationService {
    List<ConsultationResponseDto> getAll();
    ConsultationResponseDto getById(long id);
    List<ConsultationPublicResponseDto> getByDniPatient(String dniPatient);
    List<ConsultationPublicResponseDto> getByDniDoctor(String dniDoctor);
    ConsultationPublicResponseDto addConsultation(ConsultationRequestDto consultationRequestDto);
}
