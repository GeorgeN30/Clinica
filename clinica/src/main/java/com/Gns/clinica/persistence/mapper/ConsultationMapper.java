package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;
import com.Gns.clinica.persistence.entity.ConsultationEntity;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    @Mapping(source = "idConsultation", target = "idConsultation")
    @Mapping(source = "reservation.idReservation", target = "idReservation")
    @Mapping(source = "patient.idUser", target = "idPatient")
    @Mapping(source = "patient.firstName", target = "namePatient")
    @Mapping(source = "doctor.idUser", target = "idDoctor")
    @Mapping(source = "doctor.firstName", target = "nameDoctor")
    @Mapping(source = "doctor.specialties.nameSpecialty", target = "nameSpecialty")
    @Mapping(source = "consultationDate", target = "consultationDate")
    @Mapping(source = "reason", target = "reason")
    @Mapping(source = "diagnosis", target = "diagnosis")
    @Mapping(source = "treatment", target = "treatment")
    @Mapping(source = "notes", target = "notes")
    ConsultationResponseDto toResponseDto(ConsultationEntity consultationEntity);
    List<ConsultationResponseDto> toResponseDto(List<ConsultationEntity> consultationEntityList);


    @Mapping(source = "reservation.idReservation", target = "idReservation")
    @Mapping(source = "patient.firstName", target = "namePatient")
    @Mapping(source = "doctor.firstName", target = "nameDoctor")
    @Mapping(source = "doctor.specialties.nameSpecialty", target = "nameSpecialty")
    @Mapping(source = "consultationDate", target = "consultationDate")
    @Mapping(source = "reason", target = "reason")
    @Mapping(source = "diagnosis", target = "diagnosis")
    @Mapping(source = "treatment", target = "treatment")
    @Mapping(source = "notes", target = "notes")
    ConsultationPublicResponseDto toPublicResponseDto(ConsultationEntity consultationEntity);
    List<ConsultationPublicResponseDto> toPublicResponseDto(List<ConsultationEntity> consultationEntityList);


    @Mapping(source = "reservation.idReservation", target = "idReservation")
    @Mapping(source = "patient.idUser", target = "idPatient")
    @Mapping(source = "doctor.idUser", target = "idDoctor")
    @Mapping(source = "consultationDate", target = "consultationDate")
    @Mapping(source = "reason", target = "reason")
    @Mapping(source = "diagnosis", target = "diagnosis")
    @Mapping(source = "treatment", target = "treatment")
    @Mapping(source = "notes", target = "notes")
    ConsultationRequestDto toRequestDto(ConsultationEntity consultationEntity);

    @InheritInverseConfiguration
    ConsultationEntity toEntity(ConsultationRequestDto requestDto);


    default ReservationEntity map(Long idReservation) {
        if (idReservation == null) return null;
        ReservationEntity reservation = new ReservationEntity();
        reservation.setIdReservation(idReservation);
        return reservation;
    }

}
