package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;

public interface ConsultationRepository {
    ConsultationResponseDto getAll();
    ConsultationResponseDto getById(long id);
    ConsultationPublicResponseDto getByNamePatient(String namePatient);
    ConsultationPublicResponseDto getByNameDoctor(String nameDoctor);
    ConsultationRequestDto addConsultation(ConsultationRequestDto consultationRequestDto);
}
