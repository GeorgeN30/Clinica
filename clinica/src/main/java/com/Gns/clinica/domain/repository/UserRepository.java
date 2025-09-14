package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.domain.enums.Role;

import java.util.List;

public interface UserRepository {
    UserRequestDto addPatient(UserRequestDto userRequestDto);
    UserRequestDto addUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAll();
    List<UserResponseDto> getAllByRolePatient(Role role);
    List<UserResponseDto> getAllByRoleDoctor(Role role);
    List<UserResponseDto> getAllByRoleAdmin(Role role);
    UserResponseDto getFirstByDni(String dni);
    UserRequestDto updateUser(String dni, UpdateUserDto updateUserDto);
    UserRequestDto updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto);
}
