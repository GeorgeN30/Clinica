package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.SpecialtyRequestDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.SpecialtyResponseDto;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-21T15:52:53-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class SpecialtyMapperImpl implements SpecialtyMapper {

    @Override
    public SpecialtyResponseDto toDto(SpecialtyEntity specialtyEntity) {
        if ( specialtyEntity == null ) {
            return null;
        }

        Long idSpecialty = null;
        String nameSpecialty = null;

        idSpecialty = specialtyEntity.getIdSpecialty();
        nameSpecialty = specialtyEntity.getNameSpecialty();

        SpecialtyResponseDto specialtyResponseDto = new SpecialtyResponseDto( idSpecialty, nameSpecialty );

        return specialtyResponseDto;
    }

    @Override
    public List<SpecialtyResponseDto> toDto(List<SpecialtyEntity> specialtyEntities) {
        if ( specialtyEntities == null ) {
            return null;
        }

        List<SpecialtyResponseDto> list = new ArrayList<SpecialtyResponseDto>( specialtyEntities.size() );
        for ( SpecialtyEntity specialtyEntity : specialtyEntities ) {
            list.add( toDto( specialtyEntity ) );
        }

        return list;
    }

    @Override
    public SpecialtyRequestDto toRequestDto(SpecialtyEntity specialtyEntity) {
        if ( specialtyEntity == null ) {
            return null;
        }

        String nameSpecialty = null;

        nameSpecialty = specialtyEntity.getNameSpecialty();

        SpecialtyRequestDto specialtyRequestDto = new SpecialtyRequestDto( nameSpecialty );

        return specialtyRequestDto;
    }

    @Override
    public SpecialtyPublicResponseDto toPublicDto(SpecialtyEntity specialtyEntity) {
        if ( specialtyEntity == null ) {
            return null;
        }

        String nameSpecialty = null;

        nameSpecialty = specialtyEntity.getNameSpecialty();

        SpecialtyPublicResponseDto specialtyPublicResponseDto = new SpecialtyPublicResponseDto( nameSpecialty );

        return specialtyPublicResponseDto;
    }

    @Override
    public List<SpecialtyPublicResponseDto> toPublicDto(List<SpecialtyEntity> specialtyEntities) {
        if ( specialtyEntities == null ) {
            return null;
        }

        List<SpecialtyPublicResponseDto> list = new ArrayList<SpecialtyPublicResponseDto>( specialtyEntities.size() );
        for ( SpecialtyEntity specialtyEntity : specialtyEntities ) {
            list.add( toPublicDto( specialtyEntity ) );
        }

        return list;
    }

    @Override
    public SpecialtyEntity toEntity(SpecialtyRequestDto specialtyRequestDto) {
        if ( specialtyRequestDto == null ) {
            return null;
        }

        SpecialtyEntity.SpecialtyEntityBuilder specialtyEntity = SpecialtyEntity.builder();

        specialtyEntity.nameSpecialty( specialtyRequestDto.nameSpecialty() );

        return specialtyEntity.build();
    }

    @Override
    public void updateEntityFromDto(SpecialtyRequestDto specialtyRequestDto, SpecialtyEntity specialtyEntity) {
        if ( specialtyRequestDto == null ) {
            return;
        }

        specialtyEntity.setNameSpecialty( specialtyRequestDto.nameSpecialty() );
    }
}
