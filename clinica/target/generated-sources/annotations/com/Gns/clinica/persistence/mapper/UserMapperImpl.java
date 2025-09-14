package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.SpecialtyPublicResponseDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
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
    date = "2025-09-13T23:22:20-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserRequestDto toRequestDto(UserEntity entity) {
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
        Boolean disabled = null;
        Boolean locked = null;
        Long idSpecialty = null;

        dni = entity.getDni();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        password = entity.getPassword();
        phone = entity.getPhone();
        role = entity.getRole();
        status = entity.getStatus();
        disabled = entity.getDisabled();
        locked = entity.getLocked();
        idSpecialty = map( entity.getSpecialties() );

        UserRequestDto userRequestDto = new UserRequestDto( dni, firstName, lastName, email, password, phone, role, status, disabled, locked, idSpecialty );

        return userRequestDto;
    }

    @Override
    public UserEntity toEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.dni( userRequestDto.dni() );
        userEntity.firstName( userRequestDto.firstName() );
        userEntity.lastName( userRequestDto.lastName() );
        userEntity.email( userRequestDto.email() );
        userEntity.password( userRequestDto.password() );
        userEntity.phone( userRequestDto.phone() );
        userEntity.role( userRequestDto.role() );
        userEntity.status( userRequestDto.status() );
        userEntity.disabled( userRequestDto.disabled() );
        userEntity.locked( userRequestDto.locked() );
        userEntity.specialties( map( userRequestDto.idSpecialty() ) );

        return userEntity.build();
    }

    @Override
    public UserResponseDto toResponseDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        String dni = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String phone = null;
        Role role = null;
        SpecialtyPublicResponseDto specialties = null;

        dni = userEntity.getDni();
        firstName = userEntity.getFirstName();
        lastName = userEntity.getLastName();
        email = userEntity.getEmail();
        phone = userEntity.getPhone();
        role = userEntity.getRole();
        specialties = specialtyEntityToSpecialtyPublicResponseDto( userEntity.getSpecialties() );

        UserResponseDto userResponseDto = new UserResponseDto( dni, firstName, lastName, email, phone, role, specialties );

        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> toResponseDto(List<UserEntity> userEntities) {
        if ( userEntities == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( userEntities.size() );
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
        userEntity.setDisabled( updateUserStatusDto.disabled() );
        userEntity.setLocked( updateUserStatusDto.locked() );
    }

    protected SpecialtyPublicResponseDto specialtyEntityToSpecialtyPublicResponseDto(SpecialtyEntity specialtyEntity) {
        if ( specialtyEntity == null ) {
            return null;
        }

        String nameSpecialty = null;

        nameSpecialty = specialtyEntity.getNameSpecialty();

        SpecialtyPublicResponseDto specialtyPublicResponseDto = new SpecialtyPublicResponseDto( nameSpecialty );

        return specialtyPublicResponseDto;
    }
}
