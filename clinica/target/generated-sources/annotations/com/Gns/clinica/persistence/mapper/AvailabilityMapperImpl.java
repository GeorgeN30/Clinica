package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.AvailabilityRequestDto;
import com.Gns.clinica.domain.dto.response.AvailabilityPublicResponseDto;
import com.Gns.clinica.domain.dto.response.AvailabilityResponseDto;
import com.Gns.clinica.domain.enums.AvailabilityStatus;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-24T22:12:03-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class AvailabilityMapperImpl implements AvailabilityMapper {

    @Override
    public AvailabilityResponseDto toResponseDto(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }

        Long idAvailability = null;
        Long idDoctor = null;
        String nameDoctor = null;
        Long idSpecialty = null;
        String nameSpecialty = null;
        LocalDate date = null;
        LocalTime startTime = null;
        LocalTime endTime = null;
        AvailabilityStatus status = null;

        idAvailability = availabilityEntity.getIdAvailability();
        idDoctor = availabilityEntityDoctorIdUser( availabilityEntity );
        nameDoctor = availabilityEntityDoctorFirstName( availabilityEntity );
        idSpecialty = availabilityEntityDoctorSpecialtiesIdSpecialty( availabilityEntity );
        nameSpecialty = availabilityEntityDoctorSpecialtiesNameSpecialty( availabilityEntity );
        date = availabilityEntity.getDate();
        startTime = availabilityEntity.getStartTime();
        endTime = availabilityEntity.getEndTime();
        status = availabilityEntity.getStatus();

        AvailabilityResponseDto availabilityResponseDto = new AvailabilityResponseDto( idAvailability, idDoctor, nameDoctor, idSpecialty, nameSpecialty, date, startTime, endTime, status );

        return availabilityResponseDto;
    }

    @Override
    public List<AvailabilityResponseDto> toResponseDto(List<AvailabilityEntity> availabilityEntities) {
        if ( availabilityEntities == null ) {
            return null;
        }

        List<AvailabilityResponseDto> list = new ArrayList<AvailabilityResponseDto>( availabilityEntities.size() );
        for ( AvailabilityEntity availabilityEntity : availabilityEntities ) {
            list.add( toResponseDto( availabilityEntity ) );
        }

        return list;
    }

    @Override
    public AvailabilityPublicResponseDto toPublicResponseDto(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }

        String nameDoctor = null;
        String nameSpecialty = null;
        LocalDate date = null;
        LocalTime startTime = null;
        LocalTime endTime = null;

        nameDoctor = availabilityEntityDoctorFirstName( availabilityEntity );
        nameSpecialty = availabilityEntityDoctorSpecialtiesNameSpecialty( availabilityEntity );
        date = availabilityEntity.getDate();
        startTime = availabilityEntity.getStartTime();
        endTime = availabilityEntity.getEndTime();

        AvailabilityPublicResponseDto availabilityPublicResponseDto = new AvailabilityPublicResponseDto( nameDoctor, nameSpecialty, date, startTime, endTime );

        return availabilityPublicResponseDto;
    }

    @Override
    public List<AvailabilityPublicResponseDto> toPublicResponseDto(List<AvailabilityEntity> availabilityEntities) {
        if ( availabilityEntities == null ) {
            return null;
        }

        List<AvailabilityPublicResponseDto> list = new ArrayList<AvailabilityPublicResponseDto>( availabilityEntities.size() );
        for ( AvailabilityEntity availabilityEntity : availabilityEntities ) {
            list.add( toPublicResponseDto( availabilityEntity ) );
        }

        return list;
    }

    @Override
    public AvailabilityRequestDto toRequestDto(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }

        Long idDoctor = null;
        LocalDate date = null;
        LocalTime startTime = null;
        LocalTime endTime = null;
        AvailabilityStatus status = null;

        idDoctor = availabilityEntityDoctorIdUser( availabilityEntity );
        date = availabilityEntity.getDate();
        startTime = availabilityEntity.getStartTime();
        endTime = availabilityEntity.getEndTime();
        status = availabilityEntity.getStatus();

        AvailabilityRequestDto availabilityRequestDto = new AvailabilityRequestDto( idDoctor, date, startTime, endTime, status );

        return availabilityRequestDto;
    }

    @Override
    public AvailabilityEntity toEntity(AvailabilityRequestDto availabilityRequestDto) {
        if ( availabilityRequestDto == null ) {
            return null;
        }

        AvailabilityEntity.AvailabilityEntityBuilder availabilityEntity = AvailabilityEntity.builder();

        availabilityEntity.doctor( availabilityRequestDtoToUserEntity( availabilityRequestDto ) );
        availabilityEntity.date( availabilityRequestDto.date() );
        availabilityEntity.startTime( availabilityRequestDto.startTime() );
        availabilityEntity.endTime( availabilityRequestDto.endTime() );
        availabilityEntity.status( availabilityRequestDto.status() );

        return availabilityEntity.build();
    }

    private Long availabilityEntityDoctorIdUser(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        UserEntity doctor = availabilityEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long idUser = doctor.getIdUser();
        if ( idUser == null ) {
            return null;
        }
        return idUser;
    }

    private String availabilityEntityDoctorFirstName(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        UserEntity doctor = availabilityEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        String firstName = doctor.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private Long availabilityEntityDoctorSpecialtiesIdSpecialty(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        UserEntity doctor = availabilityEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        SpecialtyEntity specialties = doctor.getSpecialties();
        if ( specialties == null ) {
            return null;
        }
        Long idSpecialty = specialties.getIdSpecialty();
        if ( idSpecialty == null ) {
            return null;
        }
        return idSpecialty;
    }

    private String availabilityEntityDoctorSpecialtiesNameSpecialty(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        UserEntity doctor = availabilityEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        SpecialtyEntity specialties = doctor.getSpecialties();
        if ( specialties == null ) {
            return null;
        }
        String nameSpecialty = specialties.getNameSpecialty();
        if ( nameSpecialty == null ) {
            return null;
        }
        return nameSpecialty;
    }

    protected UserEntity availabilityRequestDtoToUserEntity(AvailabilityRequestDto availabilityRequestDto) {
        if ( availabilityRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( availabilityRequestDto.idDoctor() );

        return userEntity.build();
    }
}
