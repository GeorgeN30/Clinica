package com.Gns.clinica.domain.service.impl;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserPublicResponseDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.enums.UserStatus;
import com.Gns.clinica.domain.exception.*;
import com.Gns.clinica.domain.repository.UserRepository;
import com.Gns.clinica.domain.service.interfaces.UserServiceInterface;
import com.Gns.clinica.persistence.entity.UserEntity;
import com.Gns.clinica.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    private void validateUserDoesNotExist(UserRequestDto dto) {
        this.userRepository.findFirstByDni(dto.dni())
                .ifPresent(m -> { throw new UserAlreadyExistException(dto.dni()); });

        this.userRepository.findFirstByEmail(dto.email())
                .ifPresent(m -> { throw new EmailAlreadyExistsException(dto.email()); });
    }


    @Override
    public UserPublicResponseDto addPatient(UserRequestDto userRequestDto) {
        validateUserDoesNotExist(userRequestDto);

        UserEntity userEntity = userMapper.toEntity(userRequestDto);

        userEntity.setRole(Role.PATIENT);
        userEntity.setStatus(UserStatus.ACTIVE);
        userEntity.setDisabled(false);
        userEntity.setLocked(false);

        UserEntity savePatient = this.userRepository.save(userEntity);

        return this.userMapper.toPublicResponseDto(savePatient);
    }

    @Override
    public UserPublicResponseDto addUser(UserRequestDto userRequestDto) {
        validateUserDoesNotExist(userRequestDto);

        UserEntity userEntity = userMapper.toEntity(userRequestDto);

        userEntity.setStatus(UserStatus.ACTIVE);
        userEntity.setDisabled(false);
        userEntity.setLocked(false);

        UserEntity savedUser = this.userRepository.save(userEntity);

        return this.userMapper.toPublicResponseDto(savedUser);
    }

    @Override
    public UserResponseDto getById(long id) {
        return this.userRepository.findById(id)
                .map(userMapper::toResponseDto)
                .orElseThrow(()-> new UserNotFoundByIdException(id));
    }

    @Override
    public List<UserResponseDto> getAll() {
        return this.userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getAllByRolePatient(Role role) {
        return this.userRepository.findAllByRole(Role.PATIENT)
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getAllByRoleDoctor(Role role) {
        return this.userRepository.findAllByRole(Role.DOCTOR)
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getAllByRoleAdmin(Role role) {
        return this.userRepository.findAllByRole(Role.ADMIN)
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public UserPublicResponseDto getFirstByDni(String dni) {
        return this.userRepository.findFirstByDni(dni)
                .map(userMapper::toPublicResponseDto)
                .orElseThrow(()-> new UserNotFoundByDniException(dni));
    }

    @Override
    public UserPublicResponseDto getFirstByEmail(String email) {
        return this.userRepository.findFirstByEmail(email)
                .map(userMapper::toPublicResponseDto)
                .orElseThrow(()-> new UserNotFoundByEmailException(email));
    }

    @Override
    public UserPublicResponseDto updateUser(String dni, UpdateUserDto updateUserDto) {
        UserEntity user = this.userRepository.findFirstByDni(dni)
                .orElseThrow(() -> new UserNotFoundByDniException(dni));

        user.setFirstName(updateUserDto.firstName());
        user.setLastName(updateUserDto.lastName());
        user.setEmail(updateUserDto.email());
        user.setPhone(updateUserDto.phone());

        UserEntity updatedUser = this.userRepository.save(user);
        return userMapper.toPublicResponseDto(updatedUser);
    }

    @Override
    public UserPublicResponseDto updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto) {
        UserEntity user = this.userRepository.findFirstByDni(dni)
                .orElseThrow(() -> new UserNotFoundByDniException(dni));

        user.setStatus(updateUserStatusDto.status());
        user.setLocked(updateUserStatusDto.locked());
        user.setDisabled(updateUserStatusDto.disabled());

        UserEntity updatedUser = this.userRepository.save(user);
        return userMapper.toPublicResponseDto(updatedUser);
    }
}
