package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.UserDtoRequest;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.SpecialtyDtoResponse;
import com.Gns.clinica.domain.dto.response.UserDtoResponse;
import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.enums.UserStatus;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-13T12:51:20-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDtoRequest toRequestDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String dni = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String password = null;
        String phone = null;
        Role role = null;
        UserStatus status = null;
        Long idSpecialty = null;

        dni = entity.getDni();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        password = entity.getPassword();
        phone = entity.getPhone();
        role = entity.getRole();
        status = entity.getStatus();
        idSpecialty = map( entity.getSpecialties() );

        UserDtoRequest userDtoRequest = new UserDtoRequest( dni, firstName, lastName, email, password, phone, role, status, idSpecialty );

        return userDtoRequest;
    }

    @Override
    public UserEntity toEntity(UserDtoRequest userDtoRequest) {
        if ( userDtoRequest == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.dni( userDtoRequest.dni() );
        userEntity.firstName( userDtoRequest.firstName() );
        userEntity.lastName( userDtoRequest.lastName() );
        userEntity.email( userDtoRequest.email() );
        userEntity.password( userDtoRequest.password() );
        userEntity.phone( userDtoRequest.phone() );
        userEntity.role( userDtoRequest.role() );
        userEntity.status( userDtoRequest.status() );
        userEntity.specialties( map( userDtoRequest.idSpecialty() ) );

        return userEntity.build();
    }

    @Override
    public UserDtoResponse toResponseDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        String dni = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String phone = null;
        Role role = null;
        SpecialtyDtoResponse specialties = null;

        dni = userEntity.getDni();
        firstName = userEntity.getFirstName();
        lastName = userEntity.getLastName();
        email = userEntity.getEmail();
        phone = userEntity.getPhone();
        role = userEntity.getRole();
        specialties = specialtyEntityToSpecialtyDtoResponse( userEntity.getSpecialties() );

        UserDtoResponse userDtoResponse = new UserDtoResponse( dni, firstName, lastName, email, phone, role, specialties );

        return userDtoResponse;
    }

    @Override
    public List<UserDtoResponse> toResponseDto(List<UserEntity> userEntities) {
        if ( userEntities == null ) {
            return null;
        }

        List<UserDtoResponse> list = new ArrayList<UserDtoResponse>( userEntities.size() );
        for ( UserEntity userEntity : userEntities ) {
            list.add( toResponseDto( userEntity ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(UpdateUserDto updateUserDto, UserEntity userEntity) {
        if ( updateUserDto == null ) {
            return;
        }

        userEntity.setFirstName( updateUserDto.firstName() );
        userEntity.setLastName( updateUserDto.lastName() );
        userEntity.setEmail( updateUserDto.email() );
        userEntity.setSpecialties( map( updateUserDto.idSpecialty() ) );
        userEntity.setPhone( updateUserDto.phone() );
    }

    @Override
    public void updateStatusEntityFromDto(UpdateUserStatusDto updateUserStatusDto, UserEntity userEntity) {
        if ( updateUserStatusDto == null ) {
            return;
        }

        if ( updateUserStatusDto.status() != null ) {
            userEntity.setStatus( Enum.valueOf( UserStatus.class, updateUserStatusDto.status() ) );
        }
        else {
            userEntity.setStatus( null );
        }
    }

    protected SpecialtyDtoResponse specialtyEntityToSpecialtyDtoResponse(SpecialtyEntity specialtyEntity) {
        if ( specialtyEntity == null ) {
            return null;
        }

        Long idSpecialty = null;
        String nameSpecialty = null;

        idSpecialty = specialtyEntity.getIdSpecialty();
        nameSpecialty = specialtyEntity.getNameSpecialty();

        SpecialtyDtoResponse specialtyDtoResponse = new SpecialtyDtoResponse( idSpecialty, nameSpecialty );

        return specialtyDtoResponse;
    }
}
