package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.UserDtoRequest;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserDtoResponse;
import com.Gns.clinica.domain.enums.Role;

import java.util.List;

public interface UserRepository {
    UserDtoRequest addPatient(UserDtoRequest  userDtoRequest);
    UserDtoRequest addUser(UserDtoRequest  userDtoRequest);
    List<UserDtoResponse> getAll();
    List<UserDtoResponse> getAllByRolePatient(Role role);
    List<UserDtoResponse> getAllByRoleDoctor(Role role);
    List<UserDtoResponse> getAllByRoleAdmin(Role role);
    UserDtoResponse getFirstByDni(String dni);
    UserDtoRequest updateUser(String dni, UpdateUserDto updateUserDto);
    UserDtoRequest updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto);
}
