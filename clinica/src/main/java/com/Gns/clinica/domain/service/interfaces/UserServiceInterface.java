package com.Gns.clinica.domain.service.interfaces;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserPublicResponseDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.domain.enums.Role;

import java.util.List;

public interface UserServiceInterface {
    UserPublicResponseDto addPatient(UserRequestDto userRequestDto);
    UserPublicResponseDto addUser(UserRequestDto userRequestDto);
    UserResponseDto getById(long id);
    List<UserResponseDto> getAll();
    List<UserResponseDto> getAllByRolePatient(Role role);
    List<UserResponseDto> getAllByRoleDoctor(Role role);
    List<UserResponseDto> getAllByRoleAdmin(Role role);
    UserPublicResponseDto getFirstByDni(String dni);
    UserPublicResponseDto getFirstByEmail(String email);
    UserPublicResponseDto updateUser(String dni, UpdateUserDto updateUserDto);
    UserPublicResponseDto updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto);
}
