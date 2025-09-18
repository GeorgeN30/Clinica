package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationDto;
import com.Gns.clinica.domain.dto.request.update.UpdateReservationStatusDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "idReservation", target = "idReservation")
    @Mapping(source = "patient.idUser", target = "idPatient")
    @Mapping(source = "patient.firstName", target = "namePatient")
    @Mapping(source = "doctor.idUser", target = "idDoctor")
    @Mapping(source = "doctor.firstName", target = "nameDoctor")
    @Mapping(source = "doctor.specialties.nameSpecialty", target = "nameSpecialty")
    @Mapping(source = "branch.idBranch", target = "idBranch")
    @Mapping(source = "branch.name", target = "nameBranch")
    @Mapping(source = "availability.idAvailability", target = "idAvailability")
    @Mapping(source = "availability.date", target = "availabilityDate")
    @Mapping(source = "availability.startTime", target = "availabilityStart")
    @Mapping(source = "availability.endTime", target = "availabilityEnd")
    @Mapping(source = "reservationDate", target = "reservationDate")
    @Mapping(source = "reservationTime", target = "reservationTime")
    @Mapping(source = "status", target = "status")
    ReservationResponseDto toResponseDto(ReservationEntity reservationEntity);
    List<ReservationResponseDto> toResponseDto(List<ReservationEntity> reservationEntityList);

    @Mapping(source = "idReservation", target = "idReservation")
    @Mapping(source = "patient.firstName", target = "namePatient")
    @Mapping(source = "doctor.firstName", target = "nameDoctor")
    @Mapping(source = "doctor.specialties.nameSpecialty", target = "nameSpecialty")
    @Mapping(source = "branch.name", target = "nameBranch")
    @Mapping(source = "availability.date", target = "availabilityDate")
    @Mapping(source = "availability.startTime", target = "availabilityStart")
    @Mapping(source = "availability.endTime", target = "availabilityEnd")
    @Mapping(source = "reservationDate", target = "reservationDate")
    @Mapping(source = "reservationTime", target = "reservationTime")
    @Mapping(source = "status", target = "status")
    ReservationPublicResponseDto toPublicResponseDto(ReservationEntity reservationEntity);
    List<ReservationPublicResponseDto> toPublicResponseDto(List<ReservationEntity> reservationEntityList);

    @Mapping(source = "patient.idUser", target = "idPatient")
    @Mapping(source = "doctor.idUser", target = "idDoctor")
    @Mapping(source = "availability.idAvailability", target = "idAvailability")
    @Mapping(source = "branch.idBranch", target = "idBranch")
    @Mapping(source = "reservationDate", target = "reservationDate")
    @Mapping(source = "reservationTime", target = "reservationTime")
    @Mapping(source = "status", target = "status")
    ReservationRequestDto toRequestDto(ReservationEntity reservationEntity);
    @InheritInverseConfiguration
    ReservationEntity toEntity(ReservationRequestDto reservationRequestDto);


    @Mapping(source = "idDoctor", target = "doctor.idUser")
    @Mapping(source = "idBranch", target = "branch.idBranch")
    @Mapping(source = "idAvailability", target = "availability.idAvailability")
    @Mapping(source = "reservationDate", target = "reservationDate")
    @Mapping(source = "reservationTime", target = "reservationTime")
    void toUpdateDto(UpdateReservationDto updateReservationDto, @MappingTarget ReservationEntity reservationEntity);


    @Mapping(source = "status", target = "status")
    void toUpdateStatusDto(UpdateReservationStatusDto updateReservationStatusDto, @MappingTarget ReservationEntity reservationEntity);



    default UserEntity map(Long idDoctor) {
        if (idDoctor == null) return null;
        UserEntity doctor = new UserEntity();
        doctor.setIdUser(idDoctor);
        return doctor;
    }
}
