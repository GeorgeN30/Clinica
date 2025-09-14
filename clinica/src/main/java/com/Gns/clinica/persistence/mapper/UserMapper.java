package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "disabled", target = "disabled")
    @Mapping(source = "locked", target = "locked")
    @Mapping(source = "specialties",target = "idSpecialty")
    UserRequestDto toRequestDto(UserEntity entity);

    @InheritInverseConfiguration
    UserEntity toEntity(UserRequestDto userRequestDto);

    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "specialties", target = "specialties")
    UserResponseDto toResponseDto(UserEntity userEntity);
    List<UserResponseDto> toResponseDto(List<UserEntity> userEntities);



    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "idSpecialty",target = "specialties")
    void updateEntityFromDto(UpdateUserDto updateUserDto, @MappingTarget UserEntity userEntity);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "disabled", target = "disabled")
    @Mapping(source = "locked", target = "locked")
    void updateStatusEntityFromDto(UpdateUserStatusDto  updateUserStatusDto, @MappingTarget UserEntity userEntity);

    default Long map(SpecialtyEntity specialty) {
        return specialty != null ? specialty.getIdSpecialty() : null;
    }

    default SpecialtyEntity map(Long idSpecialty) {
        if(idSpecialty == null) return null;
        SpecialtyEntity specialty = new SpecialtyEntity();
        specialty.setIdSpecialty(idSpecialty);
        return specialty;
    }


}
