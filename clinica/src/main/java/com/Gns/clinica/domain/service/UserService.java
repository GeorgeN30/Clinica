package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserPublicResponseDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRequestDto addPatient(UserRequestDto userRequestDto) {
        return this.userRepository.addPatient(userRequestDto);
    }

    public UserRequestDto addUser(UserRequestDto userRequestDto) {
        return this.userRepository.addUser(userRequestDto);
    }

    public UserResponseDto getById(long id) {
        return this.userRepository.getById(id);
    }

    public List<UserResponseDto> getAll(){
        return this.userRepository.getAll();
    }

    public List<UserResponseDto> getAllByRolPatient(Role role){
        return this.userRepository.getAllByRolePatient(role);
    }

    public List<UserResponseDto> getAllByRolDoctor(Role role){
        return this.userRepository.getAllByRoleDoctor(role);
    }

    public List<UserResponseDto> getAllByRolAdmin(Role role){
        return this.userRepository.getAllByRoleAdmin(role);
    }

    public UserPublicResponseDto getFirstByDni(String dni) {
        return this.userRepository.getFirstByDni(dni);
    }

    public UserRequestDto updateUser(String dni, UpdateUserDto updateUserDto) {
        return this.userRepository.updateUser(dni, updateUserDto);
    }

    public UserRequestDto updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto) {
        return this.userRepository.updateUserStatus(dni, updateUserStatusDto);
    }
}
