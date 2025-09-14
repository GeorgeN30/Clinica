package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateAvailabilityStatusDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {

    @Mapping(source = "idAvailability", target = "idAvailability")
    @Mapping(source = "doctor.idUser", target = "idDoctor")
    @Mapping(source = "doctor.specialties.idSpecialty", target = "idSpecialty")
    @Mapping(source = "doctor.specialties.nameSpecialty", target = "nameSpecialty")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "endTime", target = "endTime")
    @Mapping(source = "status", target = "status")
    AvailabilityResponseDto toResponseDto(AvailabilityEntity availabilityEntity);
    List<AvailabilityResponseDto> toResponseDto(List<AvailabilityEntity> availabilityEntities);



    @Mapping(source = "doctor.firstName", target = "nameDoctor")
    @Mapping(source = "doctor.specialties.nameSpecialty", target = "nameSpecialty")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "endTime", target = "endTime")
    AvailabilityPublicResponseDto toPublicResponseDto(AvailabilityEntity availabilityEntity);
    List<AvailabilityPublicResponseDto> toPublicResponseDto(List<AvailabilityEntity> availabilityEntities);



    @Mapping(source = "doctor.idUser", target = "idDoctor")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "endTime", target = "endTime")
    @Mapping(source = "status", target = "status")
    AvailabilityRequestDto toRequestDto(AvailabilityEntity availabilityEntity);

    @InheritInverseConfiguration
    AvailabilityEntity toEntity(AvailabilityRequestDto availabilityRequestDto);


    @Mapping(source = "idDoctor", target = "doctor")
    void updateToEntityFromDto(AvailabilityRequestDto availabilityRequestDto, @MappingTarget AvailabilityEntity availabilityEntity);


    void updateStatusToEntityFromDto(UpdateAvailabilityStatusDto  updateAvailabilityStatusDto, @MappingTarget AvailabilityEntity availabilityEntity);
    UpdateAvailabilityStatusDto toStatusRequestDto(AvailabilityEntity availabilityEntity);


    default UserEntity map(Long idDoctor) {
        if (idDoctor == null) return null;
        UserEntity doctor = new UserEntity();
        doctor.setIdUser(idDoctor);
        return doctor;
    }
}
