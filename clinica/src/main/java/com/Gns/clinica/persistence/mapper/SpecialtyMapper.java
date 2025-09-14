package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper {

    @Mapping(source = "idSpecialty", target = "idSpecialty")

    SpecialtyResponseDto toDto(SpecialtyEntity specialtyEntity);
    List<SpecialtyResponseDto> toDto(List<SpecialtyEntity> specialtyEntities);

    @Mapping(source = "nameSpecialty", target = "nameSpecialty")
    SpecialtyPublicResponseDto toPublicDto(SpecialtyEntity specialtyEntity);
    @Mapping(source = "nameSpecialty", target = "nameSpecialty")
    SpecialtyRequestDto toRequestDto(SpecialtyEntity specialtyEntity);

    @InheritInverseConfiguration
    SpecialtyEntity toEntity(SpecialtyRequestDto specialtyRequestDto);


    @Mapping(source = "nameSpecialty", target = "nameSpecialty")
    void updateEntityFromDto(SpecialtyPublicResponseDto specialtyPublicResponseDto, @MappingTarget SpecialtyEntity specialtyEntity);

}
