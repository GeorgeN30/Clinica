package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.SpecialtyDto;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-13T19:52:48-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class SpecialtyMapperImpl implements SpecialtyMapper {

    @Override
    public SpecialtyDto toDto(SpecialtyEntity specialtyEntity) {
        if ( specialtyEntity == null ) {
            return null;
        }

        String idSpecialty = null;
        String nameSpecialty = null;

        if ( specialtyEntity.getIdSpecialty() != null ) {
            idSpecialty = String.valueOf( specialtyEntity.getIdSpecialty() );
        }
        nameSpecialty = specialtyEntity.getNameSpecialty();

        SpecialtyDto specialtyDto = new SpecialtyDto( idSpecialty, nameSpecialty );

        return specialtyDto;
    }

    @Override
    public List<SpecialtyDto> toDto(List<SpecialtyEntity> specialtyEntities) {
        if ( specialtyEntities == null ) {
            return null;
        }

        List<SpecialtyDto> list = new ArrayList<SpecialtyDto>( specialtyEntities.size() );
        for ( SpecialtyEntity specialtyEntity : specialtyEntities ) {
            list.add( toDto( specialtyEntity ) );
        }

        return list;
    }

    @Override
    public SpecialtyEntity toEntity(SpecialtyDto specialtyDto) {
        if ( specialtyDto == null ) {
            return null;
        }

        SpecialtyEntity.SpecialtyEntityBuilder specialtyEntity = SpecialtyEntity.builder();

        if ( specialtyDto.idSpecialty() != null ) {
            specialtyEntity.idSpecialty( Long.parseLong( specialtyDto.idSpecialty() ) );
        }
        specialtyEntity.nameSpecialty( specialtyDto.nameSpecialty() );

        return specialtyEntity.build();
    }

    @Override
    public void updateEntityFromDto(SpecialtyDto specialtyDto, SpecialtyEntity specialtyEntity) {
        if ( specialtyDto == null ) {
            return;
        }

        if ( specialtyDto.idSpecialty() != null ) {
            specialtyEntity.setIdSpecialty( Long.parseLong( specialtyDto.idSpecialty() ) );
        }
        else {
            specialtyEntity.setIdSpecialty( null );
        }
        specialtyEntity.setNameSpecialty( specialtyDto.nameSpecialty() );
    }
}
