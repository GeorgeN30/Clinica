package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;
import com.Gns.clinica.persistence.entity.BranchEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    BranchResponseDto toResponseDto(BranchEntity branchEntity);
    List<BranchResponseDto> toResponseDto(List<BranchEntity> branchEntities);


    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    BranchPublicResponseDto toPublicResponseDto(BranchEntity branchEntity);
    List<BranchPublicResponseDto> toPublicResponseDto(List<BranchEntity> branchEntities);


    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    BranchEntity toEntity(BranchRequestDto branchRequestDto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    BranchRequestDto toRequestDto(BranchEntity branchEntity);


    void updateEntityFromDto(BranchRequestDto branchRequestDto, @MappingTarget BranchEntity branchEntity);
}
