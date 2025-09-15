package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserPublicResponseDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.enums.UserStatus;
import com.Gns.clinica.domain.repository.UserRepository;
import com.Gns.clinica.persistence.crud.CrudUserEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import com.Gns.clinica.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserEntityRepository implements UserRepository {
    private final CrudUserEntity crudUserEntity;
    private final UserMapper userMapper;

    @Autowired
    public UserEntityRepository(CrudUserEntity crudUserEntity, UserMapper userMapper) {
        this.crudUserEntity = crudUserEntity;
        this.userMapper = userMapper;
    }

    @Override
    public UserRequestDto addPatient(UserRequestDto userRequestDto) {
        UserEntity userEntity = this.userMapper.toEntity(userRequestDto);
        userEntity.setStatus(UserStatus.ACTIVE);
        userEntity.setRole(Role.PATIENT);
        return this.userMapper.toRequestDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserRequestDto addUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = this.userMapper.toEntity(userRequestDto);
        return this.userMapper.toRequestDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserResponseDto getById(long id) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findById(id).orElse(null));
    }

    @Override
    public List<UserResponseDto> getAll() {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAll());
    }

    @Override
    public List<UserResponseDto> getAllByRolePatient(Role role) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAllByRole(Role.PATIENT));
    }

    @Override
    public List<UserResponseDto> getAllByRoleDoctor(Role role) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAllByRole(Role.DOCTOR));
    }

    @Override
    public List<UserResponseDto> getAllByRoleAdmin(Role role) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAllByRole(Role.ADMIN));
    }

    @Override
    public UserPublicResponseDto getFirstByDni(String dni) {
        return this.userMapper.toPublicResponseDto(this.crudUserEntity.findFirstByDni(dni));
    }

    @Override
    public UserRequestDto updateUser(String dni, UpdateUserDto updateUserDto) {
        UserEntity userEntity = this.crudUserEntity.findFirstByDni(dni);
        this.userMapper.updateEntityFromDto(updateUserDto, userEntity);
        return this.userMapper.toRequestDto(crudUserEntity.save(userEntity));
    }

    @Override
    public UserRequestDto updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto) {
        UserEntity userEntity = this.crudUserEntity.findFirstByDni(dni);
        this.userMapper.updateStatusEntityFromDto(updateUserStatusDto, userEntity);
        return this.userMapper.toRequestDto(crudUserEntity.save(userEntity));
    }
}
