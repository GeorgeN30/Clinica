package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;
import com.Gns.clinica.domain.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<ConsultationResponseDto> getAll(){
        return this.consultationRepository.getAll();
    }

    public ConsultationResponseDto getById(long id){
        return this.consultationRepository.getById(id);
    }

    public List<ConsultationPublicResponseDto> getByDniPatient(String dniPatient){
        return this.consultationRepository.getByDniPatient(dniPatient);
    }

    public List<ConsultationPublicResponseDto> getByDniDoctor(String dniDoctor){
        return this.consultationRepository.getByDniDoctor(dniDoctor);
    }

    public ConsultationRequestDto addConsultation(ConsultationRequestDto consultationRequestDto){
        return this.consultationRepository.addConsultation(consultationRequestDto);
    }
}
