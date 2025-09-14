package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.SpecialtyDto;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper {

    @Mapping(source = "idSpecialty", target = "idSpecialty")
    @Mapping(source = "nameSpecialty", target = "nameSpecialty")
    SpecialtyDto toDto(SpecialtyEntity specialtyEntity);
    List<SpecialtyDto> toDto(List<SpecialtyEntity> specialtyEntities);

    @InheritInverseConfiguration
    SpecialtyEntity toEntity(SpecialtyDto specialtyDto);

    @Mapping(source = "idSpecialty", target = "idSpecialty")
    @Mapping(source = "nameSpecialty", target = "nameSpecialty")
    void updateEntityFromDto(SpecialtyDto specialtyDto, @MappingTarget SpecialtyEntity specialtyEntity);

}
