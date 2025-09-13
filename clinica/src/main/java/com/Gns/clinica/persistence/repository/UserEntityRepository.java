package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.dto.request.UserDtoRequest;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserDtoResponse;
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
    public UserDtoRequest addPatient(UserDtoRequest userDtoRequest) {
        UserEntity userEntity = this.userMapper.toEntity(userDtoRequest);
        userEntity.setStatus(UserStatus.ACTIVE);
        userEntity.setRole(Role.PATIENT);
        return this.userMapper.toRequestDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserDtoRequest addUser(UserDtoRequest userDtoRequest) {
        UserEntity userEntity = this.userMapper.toEntity(userDtoRequest);
        return this.userMapper.toRequestDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public List<UserDtoResponse> getAll() {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAll());
    }

    @Override
    public List<UserDtoResponse> getAllByRolePatient(Role role) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAllByRole(Role.PATIENT));
    }

    @Override
    public List<UserDtoResponse> getAllByRoleDoctor(Role role) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAllByRole(Role.DOCTOR));
    }

    @Override
    public List<UserDtoResponse> getAllByRoleAdmin(Role role) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findAllByRole(Role.ADMIN));
    }

    @Override
    public UserDtoResponse getFirstByDni(String dni) {
        return this.userMapper.toResponseDto(this.crudUserEntity.findFirstByDni(dni));
    }

    @Override
    public UserDtoRequest updateUser(String dni, UpdateUserDto updateUserDto) {
        UserEntity userEntity = this.crudUserEntity.findFirstByDni(dni);
        this.userMapper.updateEntityFromDto(updateUserDto, userEntity);
        return this.userMapper.toRequestDto(crudUserEntity.save(userEntity));
    }

    @Override
    public UserDtoRequest updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto) {
        UserEntity userEntity = this.crudUserEntity.findFirstByDni(dni);
        this.userMapper.updateStatusEntityFromDto(updateUserStatusDto, userEntity);
        return this.userMapper.toRequestDto(crudUserEntity.save(userEntity));
    }
}
