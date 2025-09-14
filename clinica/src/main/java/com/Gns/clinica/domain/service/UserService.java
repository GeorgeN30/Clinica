package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.request.UserDtoRequest;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserDtoResponse;
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

    public UserDtoRequest addPatient(UserDtoRequest userDtoRequest) {
        return this.userRepository.addPatient(userDtoRequest);
    }

    public UserDtoRequest addUser(UserDtoRequest userDtoRequest) {
        return this.userRepository.addUser(userDtoRequest);
    }

    public List<UserDtoResponse> getAll(){
        return this.userRepository.getAll();
    }

    public List<UserDtoResponse> getAllByRolPatient(Role role){
        return this.userRepository.getAllByRolePatient(role);
    }

    public List<UserDtoResponse> getAllByRolDoctor(Role role){
        return this.userRepository.getAllByRoleDoctor(role);
    }

    public List<UserDtoResponse> getAllByRolAdmin(Role role){
        return this.userRepository.getAllByRoleAdmin(role);
    }

    public UserDtoResponse getFirstByDni(String dni) {
        return this.userRepository.getFirstByDni(dni);
    }

    public UserDtoRequest updateUser(String dni, UpdateUserDto updateUserDto) {
        return this.userRepository.updateUser(dni, updateUserDto);
    }

    public UserDtoRequest updateUserStatus(String dni, UpdateUserStatusDto updateUserStatusDto) {
        return this.userRepository.updateUserStatus(dni, updateUserStatusDto);
    }
}
